// Last updated: 7/14/2026, 2:25:54 PM

class Solution {
     
        
        int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root) {
        if (root == null)
            return 0;
        
        int l = Math.max(0, dfs(root.left));
        int r = Math.max(0, dfs(root.right));

        ans = Math.max(ans, root.val + l + r);

        return root.val + Math.max(l, r);
    } 
}