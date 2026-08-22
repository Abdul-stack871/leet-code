// Last updated: 8/22/2026, 12:19:17 PM
1public class Codec {
2
3    public String serialize(TreeNode root) {
4
5        if (root == null) {
6            return "";
7        }
8
9        StringBuilder sb = new StringBuilder();
10
11        preorder(root, sb);
12
13        return sb.toString();
14    }
15
16
17    private void preorder(TreeNode root, StringBuilder sb) {
18
19        if (root == null) {
20            return;
21        }
22
23        sb.append(root.val).append(" ");
24
25        preorder(root.left, sb);
26        preorder(root.right, sb);
27    }
28
29
30    public TreeNode deserialize(String data) {
31
32        if (data == null || data.length() == 0) {
33            return null;
34        }
35
36        String[] values = data.trim().split(" ");
37
38        TreeNode root = null;
39
40        for (String value : values) {
41
42            int num = Integer.parseInt(value);
43
44            root = insert(root, num);
45        }
46
47        return root;
48    }
49
50
51    private TreeNode insert(TreeNode root, int value) {
52
53        if (root == null) {
54            return new TreeNode(value);
55        }
56
57        if (value < root.val) {
58            root.left = insert(root.left, value);
59        } 
60        else {
61            root.right = insert(root.right, value);
62        }
63
64        return root;
65    }
66}