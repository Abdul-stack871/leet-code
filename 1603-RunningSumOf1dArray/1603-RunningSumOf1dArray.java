// Last updated: 7/14/2026, 2:23:11 PM
class Solution {
    public int[] runningSum(int[] nums) {
        int[] res = new int[nums.length];
        int sum = 0 ;


        for(int i = 0 ; i < nums.length ; i++){
            sum +=nums[i];
            res[i] = sum;
        }
        return res;
    }
}