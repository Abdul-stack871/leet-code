// Last updated: 11/2/2026, 8:50:52 AM
1class Solution {
2    public int minMoves2(int[] nums) {
3        Arrays.sort(nums);
4        int median = nums[nums.length / 2];
5        int moves = 0;
6
7        for (int num : nums) {
8            moves += Math.abs(num - median);
9        }
10
11        return moves;
12    }
13}