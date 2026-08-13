// Last updated: 8/13/2026, 9:46:00 AM
1class Solution {
2    class SegNode {
3        int length, maxLen, prefLen, suffLen;
4        char leftChar, rightChar;
5        
6        SegNode(char ch) {
7            this.length = 1;
8            this.maxLen = 1;
9            this.prefLen = 1;
10            this.suffLen = 1;
11            this.leftChar = ch;
12            this.rightChar = ch;
13        }
14        
15        SegNode() {} 
16    }
17
18    private SegNode[] tree;
19    private char[] chars;
20
21    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
22        int n = s.length();
23        chars = s.toCharArray();
24        tree = new SegNode[4 * n];
25        
26        buildTree(1, 0, n - 1);
27        
28        int numQueries = queryIndices.length;
29        int[] result = new int[numQueries];
30        
31        for (int i = 0; i < numQueries; i++) {
32            updateTree(1, 0, n - 1, queryIndices[i], queryCharacters.charAt(i));
33            result[i] = tree[1].maxLen; 
34        }
35        
36        return result;
37    }
38
39    private void buildTree(int node, int start, int end) {
40        if (start == end) {
41            tree[node] = new SegNode(chars[start]);
42            return;
43        }
44        int mid = start + (end - start) / 2;
45        buildTree(node * 2, start, mid);
46        buildTree(node * 2 + 1, mid + 1, end);
47        
48        tree[node] = mergeNodes(tree[node * 2], tree[node * 2 + 1]);
49    }
50
51    private void updateTree(int node, int start, int end, int idx, char c) {
52        if (start == end) {
53            tree[node] = new SegNode(c);
54            chars[idx] = c;
55            return;
56        }
57        int mid = start + (end - start) / 2;
58        if (idx <= mid) {
59            updateTree(node * 2, start, mid, idx, c);
60        } else {
61            updateTree(node * 2 + 1, mid + 1, end, idx, c);
62        }
63        
64        tree[node] = mergeNodes(tree[node * 2], tree[node * 2 + 1]);
65    }
66
67    private SegNode mergeNodes(SegNode left, SegNode right) {
68        SegNode res = new SegNode();
69        res.length = left.length + right.length;
70        res.leftChar = left.leftChar;
71        res.rightChar = right.rightChar;
72        
73        res.prefLen = left.prefLen;
74        if (left.prefLen == left.length && left.rightChar == right.leftChar) {
75            res.prefLen += right.prefLen;
76        }
77        
78        res.suffLen = right.suffLen;
79        if (right.suffLen == right.length && left.rightChar == right.leftChar) {
80            res.suffLen += left.suffLen;
81        }
82        
83        res.maxLen = Math.max(left.maxLen, right.maxLen);
84        if (left.rightChar == right.leftChar) {
85            res.maxLen = Math.max(res.maxLen, left.suffLen + right.prefLen);
86        }
87        
88        return res;
89    }
90}