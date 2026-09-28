// Last updated: 9/28/2026, 11:05:24 AM
1class Solution {
2    public int maxDepth(String s) {
3        int depth = 0, maxDepth = 0;
4        for (char c : s.toCharArray()) {
5            if (c == '(') {
6                depth++;
7                if (depth > maxDepth) maxDepth = depth;
8            } else if (c == ')') {
9                depth--;
10            }
11        }
12        return maxDepth;
13    }
14}