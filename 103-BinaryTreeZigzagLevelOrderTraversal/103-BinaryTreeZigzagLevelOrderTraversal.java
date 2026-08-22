// Last updated: 8/22/2026, 10:05:50 AM
1class Solution {
2
3    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
4
5        List<List<Integer>> res = new ArrayList<>();
6
7        if (root == null) {
8            return res;
9        }
10
11        Queue<TreeNode> q = new LinkedList<>();
12        q.offer(root);
13
14        boolean reverse = false;
15
16        while (!q.isEmpty()) {
17
18            int lvlSize = q.size();
19
20            List<Integer> subList = new ArrayList<>();
21
22            while (lvlSize != 0) {
23
24                TreeNode t = q.poll();
25
26                subList.add(t.val);
27
28                if (t.left != null) {
29                    q.offer(t.left);
30                }
31
32                if (t.right != null) {
33                    q.offer(t.right);
34                }
35
36                lvlSize--;
37            }
38
39            if (reverse) {
40                Collections.reverse(subList);
41            }
42
43            res.add(subList);
44
45            reverse = !reverse;
46        }
47
48        return res;
49    }
50}