// Last updated: 8/10/2026, 11:53:28 AM
1class Solution {
2    public int partitionDisjoint(int[] nums) {
3        int leftMax = nums[0];      
4        int currentMax = nums[0]; 
5        int partitionIdx = 0;      
6        
7        for (int i = 1; i < nums.length; i++) {
8            currentMax = Math.max(currentMax, nums[i]);
9            if (nums[i] < leftMax) {
10                leftMax = currentMax;  
11                partitionIdx = i;      
12            }
13        }
14      
15        return partitionIdx + 1;
16    }
17}