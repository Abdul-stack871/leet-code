// Last updated: 7/14/2026, 2:25:24 PM
class Solution {
    public void rotate(int[] nums, int k) {
        int x = nums.length ;
        k = k%x ;

        int[] res = new int[x];

        for(int i=0 ; i<x ; i++){
            res[(i+k) % x] = nums[i];
        }

        for(int i=0 ; i<x ; i++){
            nums[i] = res[i];
        }
        
    }
}