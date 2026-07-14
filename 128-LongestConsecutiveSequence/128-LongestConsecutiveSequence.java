// Last updated: 7/14/2026, 2:25:49 PM
class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int longest = 0;
        int count =0;
        int min = Integer.MIN_VALUE;

        for(int i =0 ;i<n;i++){
           if(nums[i]-1 == min){
            count++;
            min=nums[i];
           }
           else if(nums[i] != min){
            count=1;
            min = nums[i];
           }
           longest = Math.max(longest,count);
        }

        return longest;
    }
}