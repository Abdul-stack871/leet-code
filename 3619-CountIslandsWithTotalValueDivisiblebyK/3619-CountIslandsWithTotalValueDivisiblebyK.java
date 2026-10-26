// Last updated: 10/26/2026, 9:16:20 AM
1class Solution {
2    private void helpIslands(int[][] grid, int i, int j, int m, int n, long[] sum) {
3        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
4            return;
5        }
6        sum[0] += grid[i][j];
7        grid[i][j] = 0; 
8        
9        helpIslands(grid, i - 1, j, m, n, sum);
10        helpIslands(grid, i + 1, j, m, n, sum);
11        helpIslands(grid, i, j - 1, m, n, sum);
12        helpIslands(grid, i, j + 1, m, n, sum);
13    }
14
15    public int countIslands(int[][] grid, int k) {
16        int m = grid.length, n = grid[0].length;
17        int divI = 0;
18        
19        for (int i = 0; i < m; i++) {
20            for (int j = 0; j < n; j++) {
21                if (grid[i][j] > 0) {
22                    long[] sum = new long[1];
23                    helpIslands(grid, i, j, m, n, sum);
24                    if (sum[0] % k == 0) {
25                        divI++;
26                    }
27                }
28            }
29        }
30        return divI;
31    }
32}