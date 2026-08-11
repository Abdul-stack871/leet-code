// Last updated: 8/11/2026, 11:39:43 AM
1class Solution {
2
3    public String tree2str(TreeNode root) {
4
5        if (root == null)
6            return "";
7
8        if (root.left == null && root.right == null)
9            return root.val + "";
10
11        if (root.right == null)
12            return root.val + "(" + tree2str(root.left) + ")";
13
14        return root.val + "(" + tree2str(root.left) + ")" 
15                     + "(" + tree2str(root.right) + ")";
16    }
17}