// Last updated: 8/12/2026, 2:07:53 PM
1class Solution {
2    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
3        int m = obstacleGrid.length;
4        int n = obstacleGrid[0].length;
5
6        if (obstacleGrid[m - 1][n - 1] == 1) {
7            return 0;
8        }
9
10        int[][] dp = new int[m][n];
11
12        for (int i = m - 1; i >= 0; i--) {
13            if (obstacleGrid[i][n - 1] == 0) {
14                dp[i][n - 1] = 1;
15            } else {
16                for (int j = i; j >= 0; j--) {
17                    dp[j][n - 1] = 0;
18                }
19                break;
20            }
21        }
22
23
24        for (int i = n - 1; i >= 0; i--) {
25            if (obstacleGrid[m - 1][i] == 0) {
26                dp[m - 1][i] = 1;
27            } else {
28                for (int j = i; j >= 0; j--) {
29                    dp[m - 1][j] = 0;
30                }
31                break;
32            }
33        }
34
35        for (int i = m - 2; i >= 0; i--) {
36            for (int j = n - 2; j >= 0; j--) {
37                if (obstacleGrid[i][j] == 1) {
38                    dp[i][j] = 0;
39                } else {
40                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
41                }
42            }
43        }
44
45        return dp[0][0];
46    }
47}