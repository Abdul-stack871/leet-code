// Last updated: 8/12/2026, 11:20:40 AM
1class Solution {
2    public int maxSubarrayLength(int[] nums, int k) {
3        Map<Integer, Integer> freq = new HashMap<>();
4        int left = 0;
5        int maxLen = 0;
6        
7        for (int right = 0; right < nums.length; right++) {
8            freq.merge(nums[right], 1, Integer::sum);
9            
10            while (freq.get(nums[right]) > k) {
11                freq.merge(nums[left], -1, Integer::sum);
12                left++;
13            }
14            
15            maxLen = Math.max(maxLen, right - left + 1);
16        }
17        
18        return maxLen;
19    }
20}