// Last updated: 8/7/2026, 4:05:31 PM
1import java.util.*;
2
3class Solution {
4    private final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
5
6    public int cutOffTree(List<List<Integer>> forest) {
7        int m = forest.size();
8        int n = forest.get(0).size();
9
10        List<int[]> trees = new ArrayList<>();
11        for (int r = 0; r < m; r++) {
12            for (int c = 0; c < n; c++) {
13                int height = forest.get(r).get(c);
14                if (height > 1) {
15                    trees.add(new int[]{r, c, height});
16                }
17            }
18        }
19
20        Collections.sort(trees, (a, b) -> Integer.compare(a[2], b[2]));
21
22        int totalSteps = 0;
23        int curR = 0, curC = 0;
24
25        for (int[] tree : trees) {
26            int targetR = tree[0];
27            int targetC = tree[1];
28
29            int steps = minStepsBFS(forest, curR, curC, targetR, targetC, m, n);
30            
31            if (steps == -1) {
32                return -1;
33            }
34
35            totalSteps += steps;
36            curR = targetR;
37            curC = targetC;
38        }
39
40        return totalSteps;
41    }
42
43    private int minStepsBFS(List<List<Integer>> forest, int startR, int startC, int targetR, int targetC, int m, int n) {
44        if (startR == targetR && startC == targetC) {
45            return 0;
46        }
47
48        Queue<int[]> queue = new LinkedList<>();
49        boolean[][] visited = new boolean[m][n];
50
51        queue.offer(new int[]{startR, startC});
52        visited[startR][startC] = true;
53
54        int steps = 0;
55
56        while (!queue.isEmpty()) {
57            int size = queue.size();
58            steps++;
59
60            for (int i = 0; i < size; i++) {
61                int[] curr = queue.poll();
62                int r = curr[0];
63                int c = curr[1];
64
65                for (int[] dir : dirs) {
66                    int nextR = r + dir[0];
67                    int nextC = c + dir[1];
68
69
70                    if (nextR >= 0 && nextR < m && nextC >= 0 && nextC < n 
71                            && !visited[nextR][nextC] 
72                            && forest.get(nextR).get(nextC) >= 1) {
73                        
74                        if (nextR == targetR && nextC == targetC) {
75                            return steps;
76                        }
77
78                        visited[nextR][nextC] = true;
79                        queue.offer(new int[]{nextR, nextC});
80                    }
81                }
82            }
83        }
84
85        return -1; 
86    }
87}