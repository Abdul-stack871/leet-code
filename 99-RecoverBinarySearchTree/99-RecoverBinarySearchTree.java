// Last updated: 7/14/2026, 2:26:03 PM
class Solution {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        // 1. Perform in-order traversal to find the swapped nodes
        inorder(root);
        
        // 2. Swap the values of the identified nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        
        inorder(root.left);
        
        // Logic to detect swapped nodes
        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev; // First violation: previous is the candidate
            }
            second = root; // Second violation (or update second if only one violation found)
        }
        prev = root;
        
        inorder(root.right);
    }
}