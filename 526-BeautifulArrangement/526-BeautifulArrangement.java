// Last updated: 8/5/2026, 2:14:59 PM
1class Solution {
2    int res = 0;
3    public int countArrangement(int n) {
4        if (n == 0) return 0;
5        backtrack(1, n, new int[n+1]);
6        return res;
7    }
8
9    private void backtrack(int pos, int n, int[] usedValueArr) {
10        if (pos > n) {
11            res++;
12            return;
13        }
14        for (int i = 1; i <= n; i++) {
15            if (usedValueArr[i] == 0 && (pos % i == 0 || i % pos == 0)) {
16                usedValueArr[i] = 1;
17                backtrack(pos+1, n, usedValueArr);
18                usedValueArr[i] = 0;
19            }
20        }
21    }
22}