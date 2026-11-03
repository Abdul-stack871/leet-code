// Last updated: 11/3/2026, 9:25:47 AM
1class Solution {
2    public int minMoves(int[] nums) {
3        if (nums == null || nums.length == 0) return 0; 
4
5        long sum = 0L;
6        int mx = Integer.MIN_VALUE;
7
8        for (int x : nums) {
9            sum += x;
10            if (x > mx) mx = x;
11        }
12
13        long result = (long) nums.length * mx - sum;
14        return (int) result;
15    }
16}