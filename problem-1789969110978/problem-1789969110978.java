// Last updated: 9/21/2026, 11:08:30 AM
1class Solution {
2    public long[] resultArray(int[] nums, int k) {
3        long[] result = new long[k];
4        long[] curr = new long[k];
5
6        for (int num : nums) {
7            long[] next = new long[k];
8            int mod = num % k;
9            
10            next[mod]++;
11
12            for (int j = 0; j < k; j++) {
13                if (curr[j] > 0) {
14                    int rem = (int) ((long) j * mod % k);
15                    next[rem] += curr[j];
16                }
17            }
18
19            for (int j = 0; j < k; j++) {
20                result[j] += next[j];
21            }
22
23            curr = next;
24        }
25
26        return result;
27    }
28}