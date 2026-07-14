// Last updated: 7/14/2026, 2:23:56 PM
class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sam = 0;

        for(int i=0 ; i<nums.length ; i+=2){
            sam += nums[i];
        }

        return sam ;
        
    }
}