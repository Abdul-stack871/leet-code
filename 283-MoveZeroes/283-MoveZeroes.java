// Last updated: 9/29/2026, 10:58:23 AM
1class Solution {
2    public void moveZeroes(int[] nums) {
3        
4        int idx = 0;
5
6        for(int i=0 ; i<nums.length ; i++){
7
8            if(nums[i] != 0){
9                nums[idx] = nums[i];
10                idx++ ;
11            }
12        }
13
14            while(idx < nums.length){
15                nums[idx] = 0;
16                idx++ ;
17            }
18
19
20        
21    }
22}