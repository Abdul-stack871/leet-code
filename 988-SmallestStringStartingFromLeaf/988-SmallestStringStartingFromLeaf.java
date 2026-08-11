// Last updated: 8/11/2026, 11:30:53 AM
1class Solution {
2    String ans = "";
3
4    public String smallestFromLeaf(TreeNode root) {
5        find(root, "");
6        return ans;
7    }
8
9    void find(TreeNode root, String s) {
10
11        if (root == null)
12            return;
13
14        char ch = (char)('a' + root.val);
15
16        // Add character in front
17        s = ch + s;
18
19        // Leaf node
20        if (root.left == null && root.right == null) {
21
22            if (ans.equals("") || s.compareTo(ans) < 0)
23                ans = s;
24
25            return;
26        }
27
28        find(root.left, s);
29        find(root.right, s);
30    }
31}