// Last updated: 7/14/2026, 2:26:08 PM

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();


        inorder(root, res);
        return res;
    }



    private void inorder(TreeNode node, List<Integer> res) {
    if (node == null) {
        return;
    }
    inorder(node.left, res);
    res.add(node.val);
    inorder(node.right, res); 
}
}