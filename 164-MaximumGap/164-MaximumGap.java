// Last updated: 7/15/2026, 2:04:12 PM
1class Solution {
2    public int maximumGap(int[] nums) {
3        int n = nums.length;
4        if (n < 2) return 0;
5
6        int min = nums[0];
7        int max = nums[0];
8
9        for (int x : nums) {
10            min = Math.min(min, x);
11            max = Math.max(max, x);
12        }
13
14        if (min == max) return 0;
15
16        int bucketSize = Math.max(1, (max - min) / (n - 1));
17        int bucketCount = (max - min) / bucketSize + 1;
18
19        int[] bucketMin = new int[bucketCount];
20        int[] bucketMax = new int[bucketCount];
21        boolean[] used = new boolean[bucketCount];
22
23        Arrays.fill(bucketMin, Integer.MAX_VALUE);
24        Arrays.fill(bucketMax, Integer.MIN_VALUE);
25
26        for (int x : nums) {
27            int idx = (x - min) / bucketSize;
28
29            bucketMin[idx] = Math.min(bucketMin[idx], x);
30            bucketMax[idx] = Math.max(bucketMax[idx], x);
31            used[idx] = true;
32        }
33
34        int ans = 0;
35        int prev = min;
36
37        for (int i = 0; i < bucketCount; i++) {
38            if (!used[i]) continue;
39
40            ans = Math.max(ans, bucketMin[i] - prev);
41            prev = bucketMax[i];
42        }
43
44        return ans;
45    }
46}