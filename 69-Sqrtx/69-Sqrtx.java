// Last updated: 7/14/2026, 2:26:37 PM
class Solution {
    public int mySqrt(int x) {
         int left = 1;
        int right = x;

        int ans = 0;

        while(left <= right) {

            int mid = left + (right - left) / 2;

            long square = (long) mid * mid;

            if(square == x) {
                return mid;
            }

            else if(square < x) {

                ans = mid;
                left = mid + 1;

            }

            else {

                right = mid - 1;

            }
        }

        return ans;
    }
}