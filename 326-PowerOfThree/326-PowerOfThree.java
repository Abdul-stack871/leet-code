// Last updated: 7/14/2026, 2:24:53 PM
class Solution {
    public boolean isPowerOfThree(int n) {
        int maxPowerOf3 = 1162261467 ;
        return n>0 && maxPowerOf3 % n == 0;
    }
}