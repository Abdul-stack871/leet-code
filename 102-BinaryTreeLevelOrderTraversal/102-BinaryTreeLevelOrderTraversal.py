# Last updated: 8/18/2026, 4:31:25 PM
1from collections import deque
2class Solution:
3    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
4        if not root:
5            return[]
6
7        q = deque([root])
8        levels = [[root.val]]
9        tmp = deque()
10
11        while q:
12            node = q.popleft()
13            if node.left: tmp.append(node.left)
14            if node.right: tmp.append(node.right)
15
16            if not q:
17                if tmp:
18                    levels.append([n.val for n in tmp])
19
20                q = tmp
21                tmp = deque()
22
23        return levels