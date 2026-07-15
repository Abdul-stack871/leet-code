// Last updated: 7/15/2026, 1:55:39 PM
1class Solution {
2    public int singleNonDuplicate(int[] nums) {
3        int ans = 0 ;
4
5        for(int num : nums){
6            ans ^= num ;
7        }
8
9        return ans ;
10    }
11}