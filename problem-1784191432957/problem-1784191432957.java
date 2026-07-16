// Last updated: 7/16/2026, 2:13:52 PM
1
2class Solution {
3
4    public boolean helper(TreeNode p, TreeNode q) {
5        if (p == null && q == null) return true;
6        
7        if (p == null || q == null) return false;
8        
9        if (p.val != q.val) return false;
10        
11        return helper(p.left, q.left) && helper(p.right, q.right);
12    }
13
14    public boolean isSameTree(TreeNode p, TreeNode q) {
15        return helper(p, q);
16    }
17}