// Last updated: 9/1/2026, 11:31:58 AM
1class Solution {
2    public int minMoves(String[] grid, int energy) {
3        int m = grid.length, n = grid[0].length(), cnt = 0;
4        int[][] id = new int[m][n];
5        int startR = 0, startC = 0;
6        
7        for (int i = 0; i < m; i++) {
8            for (int j = 0; j < n; j++) {
9                id[i][j] = -1;
10                if (grid[i].charAt(j) == 'S') { startR = i; startC = j; }
11                if (grid[i].charAt(j) == 'L') id[i][j] = cnt++;
12            }
13        }
14        
15        int target = (1 << cnt) - 1;
16        int[][][] best = new int[m][n][1 << cnt];
17        for (int[][] b : best) for (int[] r : b) java.util.Arrays.fill(r, -1);
18        
19        java.util.Queue<int[]> q = new java.util.LinkedList<>();
20        q.offer(new int[]{startR, startC, 0, energy, 0});
21        best[startR][startC][0] = energy;
22        
23        int[] dir = {-1, 0, 1, 0, -1}; 
24        
25        while (!q.isEmpty()) {
26            int[] curr = q.poll();
27            int r = curr[0], c = curr[1], mask = curr[2], en = curr[3], moves = curr[4];
28            
29            if (mask == target) return moves;
30            if (en == 0) continue;
31            
32            for (int i = 0; i < 4; i++) {
33                int nr = r + dir[i], nc = c + dir[i+1];
34                
35                if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr].charAt(nc) != 'X') {
36                    char cell = grid[nr].charAt(nc);
37                    
38                    int nEn = (cell == 'R') ? energy : en - 1;
39                    int nMask = mask | ((cell == 'L') ? (1 << id[nr][nc]) : 0);
40                    
41                    if (nEn > best[nr][nc][nMask]) {
42                        best[nr][nc][nMask] = nEn;
43                        q.offer(new int[]{nr, nc, nMask, nEn, moves + 1});
44                    }
45                }
46            }
47        }
48        return -1;
49    }
50}