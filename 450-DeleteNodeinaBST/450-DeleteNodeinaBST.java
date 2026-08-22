// Last updated: 8/22/2026, 12:02:49 PM
1class Solution {
2    public TreeNode deleteNode(TreeNode root, int key) {
3        if(root == null){
4            return null ;
5        }
6
7        if(key < root.val){
8            root.left = deleteNode(root.left, key);
9        }
10
11        else if (key > root.val){
12            root.right = deleteNode(root.right, key);
13        }
14
15        else{
16
17            if(root.left == null){
18                return root.right ;
19            }
20
21
22            if(root.right == null){
23                return root.left;
24            }
25
26            TreeNode tmp = root.right ;
27
28            while(tmp.left != null){
29                tmp = tmp.left ;
30            }
31
32            root.val = tmp.val ;
33
34
35            root.right = deleteNode(root.right, tmp.val);
36        }
37
38        return root ;
39    }
40}