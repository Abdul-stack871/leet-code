// Last updated: 10/2/2026, 11:04:54 AM
1class Solution {
2    public List generateParenthesis(int n) {
3        List res = new ArrayList<>();
4        dfs(0, 0, "", n, res);
5        return res;
6    }
7
8    private void dfs(int openP, int closeP, String s, int n, List res) {
9        if (openP == closeP && openP + closeP == n * 2) {
10            res.add(s);
11            return;
12        }
13
14        if (openP < n) {
15            dfs(openP + 1, closeP, s + "(", n, res);
16        }
17
18       
19        if (closeP < openP) {
20            dfs(openP, closeP + 1, s + ")", n, res);
21        }
22    }
23}