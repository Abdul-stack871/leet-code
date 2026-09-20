// Last updated: 9/20/2026, 7:38:12 AM
1class Solution {
2    public int reverseDegree(String s) {
3        int ac = 0;
4        for (int i = 0; i < s.length(); ++i) {
5            ac += (26 - (s.charAt(i) - 'a')) * (i + 1);
6        }
7        return ac;
8    }
9}