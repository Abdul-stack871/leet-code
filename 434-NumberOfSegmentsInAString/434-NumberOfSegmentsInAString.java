// Last updated: 7/14/2026, 2:24:11 PM
class Solution {

    public int countSegments(String s) {

        String st = "";

        int count = 0;

        for(int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if(ch != ' ') {

                st += ch;

            } else {

                if(st.length() > 0) {

                    count++;

                    st = "";
                }
            }
        }

        if(st.length() > 0) {

            count++;
        }

        return count;
    }
}