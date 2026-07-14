// Last updated: 7/14/2026, 2:25:27 PM
import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {

        String[] str = new String[nums.length];

        for(int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(str, (a, b) -> (b + a).compareTo(a + b));

        String lg = "";

        for(int i = 0; i < str.length; i++) {
            lg = lg + str[i];
        }

        if(lg.charAt(0) == '0') {
            return "0";
        }

        return lg;
    }
}