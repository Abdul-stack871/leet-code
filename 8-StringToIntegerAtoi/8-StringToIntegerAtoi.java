// Last updated: 7/14/2026, 2:27:23 PM
class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int n = s.length();
        
        // Step 1: Skip leading whitespace
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        
        if (i == n) {
            return 0;
        }
        
        // Step 2: Check for sign
        int sign = 1;
        if (s.charAt(i) == '+') {
            i++;
        } else if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        
        // Step 3: Read digits and convert
        long res = 0; // Use long to detect overflow easily
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            res = res * 10 + digit;
            
            // Check for 32-bit signed integer overflow
            if (sign * res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign * res < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i++;
        }
        
        return (int) (res * sign);
    }
}