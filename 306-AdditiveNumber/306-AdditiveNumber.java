// Last updated: 7/14/2026, 2:24:57 PM
import java.math.BigInteger;

class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; Math.max(i, j) <= n - i - j; j++) {
                if (isValid(i, j, num)) return true;
            }
        }
        return false;
    }

    private boolean isValid(int i, int j, String num) {
        if (num.charAt(0) == '0' && i > 1) return false;
        if (num.charAt(i) == '0' && j > 1) return false;
        
        String s1 = num.substring(0, i);
        String s2 = num.substring(i, i + j);
        int start = i + j;
        
        while (start < num.length()) {
            BigInteger sum = new BigInteger(s1).add(new BigInteger(s2));
            String sumStr = sum.toString();
            if (!num.startsWith(sumStr, start)) return false;
            
            s1 = s2;
            s2 = sumStr;
            start += sumStr.length();
        }
        return true;
    }
}