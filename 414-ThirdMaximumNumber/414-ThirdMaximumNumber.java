// Last updated: 7/14/2026, 2:24:13 PM
class Solution {
    public int thirdMax(int[] nums) {

        long lrg = Long.MIN_VALUE ;
        long sclrg = Long.MIN_VALUE ;
        long trlrg = Long.MIN_VALUE ; 

        for(int i=0 ; i<nums.length ; i++){
            if(nums[i] == lrg || nums[i] == sclrg || nums[i] == trlrg){
                continue;
            }

            if(nums[i] > lrg){
                trlrg = sclrg ;
                sclrg = lrg ;
                lrg = nums[i];
            } else if(nums[i] > sclrg){
                trlrg = sclrg ;
                sclrg = nums[i];
            }else if(nums[i] > trlrg){
                trlrg = nums[i];
            }
        }

        if(trlrg == Long.MIN_VALUE){
            return(int) lrg ;
        }
        return (int) trlrg ;
        
    }
}