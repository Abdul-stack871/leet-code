// Last updated: 7/14/2026, 2:26:54 PM
class Solution {
    public int jump(int[] nums) {
        int near = 0 , far = 0 , jumps = 0;

        while(far < nums.length - 1){
            int frt = 0 ; 
            for(int i=near ; i<= far ; i++){
                frt = Math.max(frt,i+nums[i]);
            }

            near = far + 1 ;
            far = frt ;
            jumps++ ;
        }

        return jumps;
    }
}