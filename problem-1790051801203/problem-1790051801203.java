// Last updated: 9/22/2026, 10:06:41 AM
1class Solution {
2    static class Node {
3        int prod;
4        int[] cnt;
5
6        Node(int k) {
7            this.prod = 1 % k;
8            this.cnt = new int[k];
9        }
10    }
11
12    private Node[] tree;
13    private int n;
14    private int k;
15
16    public int[] resultArray(int[] nums, int k, int[][] queries) {
17        this.n = nums.length;
18        this.k = k;
19        this.tree = new Node[4 * n];
20
21        build(nums, 1, 0, n - 1);
22
23        int[] ans = new int[queries.length];
24
25        for (int q = 0; q < queries.length; q++) {
26            int idx = queries[q][0];
27            int val = queries[q][1];
28            int start = queries[q][2];
29            int x = queries[q][3];
30
31            update(1, 0, n - 1, idx, val);
32
33            Node res = query(1, 0, n - 1, start, n - 1);
34
35            ans[q] = res.cnt[x];
36        }
37
38        return ans;
39    }
40
41    private Node merge(Node left, Node right) {
42        Node parent = new Node(k);
43        parent.prod = (left.prod * right.prod) % k;
44
45        for (int i = 0; i < k; i++) {
46            parent.cnt[i] = left.cnt[i];
47        }
48
49        for (int i = 0; i < k; i++) {
50            int rem = (left.prod * i) % k;
51            parent.cnt[rem] += right.cnt[i];
52        }
53
54        return parent;
55    }
56
57    private void build(int[] nums, int node, int l, int r) {
58        if (l == r) {
59            tree[node] = new Node(k);
60            int rem = nums[l] % k;
61            tree[node].prod = rem;
62            tree[node].cnt[rem] = 1;
63            return;
64        }
65
66        int mid = l + (r - l) / 2;
67        build(nums, 2 * node, l, mid);
68        build(nums, 2 * node + 1, mid + 1, r);
69        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
70    }
71
72    private void update(int node, int l, int r, int idx, int val) {
73        if (l == r) {
74            tree[node] = new Node(k);
75            int rem = val % k;
76            tree[node].prod = rem;
77            tree[node].cnt[rem] = 1;
78            return;
79        }
80
81        int mid = l + (r - l) / 2;
82        if (idx <= mid) {
83            update(2 * node, l, mid, idx, val);
84        } else {
85            update(2 * node + 1, mid + 1, r, idx, val);
86        }
87
88        tree[node] = merge(tree[2 * node], tree[2 * node + 1]);
89    }
90
91    private Node query(int node, int l, int r, int ql, int qr) {
92        if (ql <= l && r <= qr) {
93            return tree[node];
94        }
95
96        int mid = l + (r - l) / 2;
97        if (qr <= mid) {
98            return query(2 * node, l, mid, ql, qr);
99        }
100        if (ql > mid) {
101            return query(2 * node + 1, mid + 1, r, ql, qr);
102        }
103
104        Node left = query(2 * node, l, mid, ql, qr);
105        Node right = query(2 * node + 1, mid + 1, r, ql, qr);
106        return merge(left, right);
107    }
108}