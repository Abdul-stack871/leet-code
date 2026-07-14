// Last updated: 7/14/2026, 2:25:21 PM
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
        
    }
}