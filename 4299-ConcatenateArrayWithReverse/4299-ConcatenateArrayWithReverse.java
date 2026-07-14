// Last updated: 7/14/2026, 2:22:52 PM
class Solution {
    public int[] concatWithReverse(int[] nums) {
          int n = nums.length;

        int[] ans = new int[2 * n];

        for(int i = 0; i < n; i++) {

            ans[i] = nums[i];

            ans[n + i] = nums[n - 1 - i];
        }

        return ans;
        
    }
}