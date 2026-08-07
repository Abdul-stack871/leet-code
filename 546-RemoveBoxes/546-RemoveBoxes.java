// Last updated: 8/7/2026, 2:15:11 PM
1class Solution {
2    public int removeBoxes(int[] boxes) {
3        int n = boxes.length;
4        int[][][] memo = new int[n][n][n];
5        return removeBoxesSub(boxes, 0, n - 1, 0, memo);
6    }
7
8    private int removeBoxesSub(int[] boxes, int i, int j, int k, int[][][] memo) {
9        if (i > j) return 0;
10        if (memo[i][j][k] > 0) return memo[i][j][k];
11    
12        int tmpi = i, tmpk = k;
13        while (i + 1 <= j && boxes[i + 1] == boxes[i]) {
14            i++;
15            k++;
16        }
17        
18        int res = (k + 1) * (k + 1) + removeBoxesSub(boxes, i + 1, j, 0, memo);
19
20        for (int m = i + 1; m <= j; m++) {
21            if (boxes[i] == boxes[m]) {
22                res = Math.max(res, removeBoxesSub(boxes, i + 1, m - 1, 0, memo) + removeBoxesSub(boxes, m, j, k + 1, memo));
23            }
24        }
25
26        memo[tmpi][j][tmpk] = res;
27        return res;
28    }
29}