// Last updated: 9/29/2026, 10:25:21 AM
1class Solution {
2    public boolean hasValidPath(char[][] grid) {
3        int m = grid.length;
4        int n = grid[0].length;
5        if ((m + n - 1) % 2 != 0) {
6            return false;
7        }
8
9        boolean[][][] dp = new boolean[m][n][m + n];
10
11        if (grid[0][0] == ')') {
12            return false;
13        }
14
15        dp[0][0][1] = true;
16
17        for (int i = 0; i < m; i++) {
18            for (int j = 0; j < n; j++) {
19
20                for (int balance = 0; balance < m + n; balance++) {
21
22                    if (!dp[i][j][balance]) {
23                        continue;
24                    }
25
26                    if (i + 1 < m) {
27                        int newBalance = balance +
28                                (grid[i + 1][j] == '(' ? 1 : -1);
29
30                        if (newBalance >= 0) {
31                            dp[i + 1][j][newBalance] = true;
32                        }
33                    }
34
35                    if (j + 1 < n) {
36                        int newBalance = balance +
37                                (grid[i][j + 1] == '(' ? 1 : -1);
38
39                        if (newBalance >= 0) {
40                            dp[i][j + 1][newBalance] = true;
41                        }
42                    }
43                }
44            }
45        }
46
47        return dp[m - 1][n - 1][0];
48    }
49}