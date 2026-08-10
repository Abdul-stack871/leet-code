// Last updated: 8/10/2026, 12:17:51 PM
1class Solution {
2    public List<String> addOperators(String num, int target) {
3        List<String> rst = new ArrayList<>();
4
5        if (num == null || num.length() == 0) {
6            return rst;
7        }
8
9        helper(rst, "", num, target, 0, 0, 0);
10        return rst;
11    }
12
13    private void helper(List<String> rst, String path, String num,int target, int pos, long eval, long multed) {
14        if (pos == num.length()) {
15            if (target == eval) {
16                rst.add(path);
17            }
18            return;
19        }
20       
21        for (int i = pos; i < num.length(); i++) {
22            if (i != pos && num.charAt(pos) == '0') {
23                break;
24            }
25
26            long cur = Long.parseLong(num.substring(pos, i + 1));
27
28            if (pos == 0) {
29                helper(rst, path + cur, num, target,i + 1, cur, cur);
30            } else {
31                helper(rst, path + "+" + cur, num, target,i + 1, eval + cur, cur);
32                helper(rst, path + "-" + cur, num, target,i + 1, eval - cur, -cur);
33                helper(rst, path + "*" + cur, num, target,i + 1,eval - multed + multed * cur,multed * cur);
34            }
35        }
36    }
37}