// Last updated: 8/8/2026, 2:49:31 PM
1class Solution {
2    public boolean isSymmetric(TreeNode root) {
3  return isMirror(root, root);
4}
5
6private boolean isMirror(TreeNode t1, TreeNode t2) {
7  if (t1 == null && t2 == null) return true;
8  if (t1 == null || t2 == null) return false;
9  if (t1.val != t2.val) return false;
10  return isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
11}
12}