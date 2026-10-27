// Last updated: 10/27/2026, 9:06:27 AM
1class Solution {
2    public String[] createGrid(int m, int n) {
3        String[] ans = new String[m];
4
5        ans[0] = ".".repeat(n);
6
7        for (int i = 1; i < m; i++) {
8            ans[i] = "#".repeat(n - 1) + ".";
9        }
10
11        return ans;
12    }
13}