// Last updated: 9/22/2026, 3:20:45 PM
1class Solution {
2    public List<String> binaryTreePaths(TreeNode root) {
3        List<String> ans = new ArrayList<>();
4        dfs(root, ans, "");
5        return ans;
6    }
7
8    static void dfs(TreeNode node, List<String> ans, String path) {
9        if (node == null)
10            return;
11
12        path += node.val;
13
14        if (node.left == null && node.right == null) {
15            ans.add(path);
16            return;
17        }
18
19        dfs(node.left, ans, path + "->");
20        dfs(node.right, ans, path + "->");
21    }
22}