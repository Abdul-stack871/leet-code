// Last updated: 7/14/2026, 2:24:40 PM
class Solution {
    public boolean isPowerOfFour(int n) {
     return n>0 && (n & (n-1)) == 0 && (n & 0x55555555) != 0 ;   
    }
}