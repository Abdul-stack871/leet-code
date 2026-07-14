// Last updated: 7/14/2026, 2:27:31 PM
import java.util.HashSet;

class Solution {

    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();

        int lft = 0;
        int mxlng = 0;

        for(int rgt = 0; rgt < s.length(); rgt++) {

            while(set.contains(s.charAt(rgt))) {

                set.remove(s.charAt(lft));
                lft++;
            }

            set.add(s.charAt(rgt));

            mxlng = Math.max(mxlng, rgt - lft + 1);
        }

        return mxlng;
    }
}