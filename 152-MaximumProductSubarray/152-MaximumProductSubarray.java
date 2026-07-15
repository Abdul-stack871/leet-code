// Last updated: 7/15/2026, 3:07:11 PM
1class Solution {
2    public int maxProduct(int[] nums) {
3        int res = nums[0];
4        int curMax = nums[0];
5        int curMin = nums[0];
6
7        for (int i = 1; i < nums.length; i++) {
8            int n = nums[i];
9            
10            // If n is negative, the max and min products swap
11            if (n < 0) {
12                int temp = curMax;
13                curMax = curMin;
14                curMin = temp;
15            }
16
17            curMax = Math.max(n, curMax * n);
18            curMin = Math.min(n, curMin * n);
19
20            res = Math.max(res, curMax);
21        }
22        return res;
23    }
24}