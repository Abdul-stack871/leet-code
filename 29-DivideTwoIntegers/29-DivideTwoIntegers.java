// Last updated: 7/14/2026, 2:27:05 PM
class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow case: -2^31 / -1 = 2^31 (which overflows int)
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Use long to prevent overflow during absolute value conversion
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        
        int result = 0;
        
        // Use bit shifting to subtract powers of the divisor
        while (dvd >= dvs) {
            long tempDvs = dvs;
            long multiple = 1;
            
            while (dvd >= (tempDvs << 1)) {
                tempDvs <<= 1;
                multiple <<= 1;
            }
            
            dvd -= tempDvs;
            result += multiple;
        }
        
        return (dividend < 0) ^ (divisor < 0) ? -result : result;
    }
}