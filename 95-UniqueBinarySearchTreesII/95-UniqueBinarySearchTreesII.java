// Last updated: 7/14/2026, 2:40:44 PM
1class Solution {
2    public List<TreeNode> generateTrees(int n) {
3        return n > 0 ? generate_trees(1, n) : new ArrayList<>();
4    }
5
6    private List<TreeNode> generate_trees(int start, int end) {
7        List<TreeNode> all_trees = new ArrayList<>();
8        if (start > end) {
9            all_trees.add(null);
10            return all_trees;
11        }
12
13        for (int i = start; i <= end; i++) {
14            List<TreeNode> left_trees = generate_trees(start, i - 1);
15            List<TreeNode> right_trees = generate_trees(i + 1, end);
16
17            for (TreeNode l : left_trees) {
18                for (TreeNode r : right_trees) {
19                    TreeNode current_tree = new TreeNode(i);
20                    current_tree.left = l;
21                    current_tree.right = r;
22                    all_trees.add(current_tree);
23                }
24            }
25        }
26        return all_trees;
27    }
28}