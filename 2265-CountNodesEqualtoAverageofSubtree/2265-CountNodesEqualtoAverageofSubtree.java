// Last updated: 9/10/2026, 9:52:41 AM
1class Solution {
2    int count = 0;
3
4    public int averageOfSubtree(TreeNode root) {
5        trav(root);
6        return count;
7    }
8
9    private int[] trav(TreeNode root) {
10        if (root == null) return new int[] {0, 0};
11
12        int[] left = trav(root.left);
13        int[] right = trav(root.right);
14
15        int subtreeSum = left[0] + right[0] + root.val;
16        int subtreeCount = left[1] + right[1] + 1;
17
18        if (subtreeSum / subtreeCount == root.val) {
19            count++;
20        }
21
22        return new int[] {subtreeSum, subtreeCount};
23    }
24}