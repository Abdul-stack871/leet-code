// Last updated: 7/14/2026, 2:26:13 PM
class Solution {
    public int numDecodings(String s) {
        // Memoization array initialized to -1
        int[] memo = new int[s.length()];
        java.util.Arrays.fill(memo, -1);
        return helper(0, s, memo);
    }

    private int helper(int p, String s, int[] memo) {
        int n = s.length();
        // Base case: reached the end, found 1 valid path
        if (p == n) return 1;
        // If current digit is '0', it's invalid
        if (s.charAt(p) == '0') return 0;
        // Return cached result if already computed
        if (memo[p] != -1) return memo[p];

        // Option 1: Decode one digit
        int res = helper(p + 1, s, memo);

        // Option 2: Decode two digits (if valid range 10-26)
        if (p < n - 1) {
            int twoDigit = Integer.parseInt(s.substring(p, p + 2));
            if (twoDigit >= 10 && twoDigit <= 26) {
                res += helper(p + 2, s, memo);
            }
        }

        return memo[p] = res;
    }
}