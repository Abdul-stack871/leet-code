// Last updated: 7/14/2026, 2:24:16 PM
class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";
        
        char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        StringBuilder sb = new StringBuilder();
        
        while (num != 0) {
            int digit = num & 0xF;
            sb.insert(0, map[digit]);
            num >>>= 4;
        }
        
        return sb.toString();
    }
}