// Last updated: 7/14/2026, 2:25:52 PM
class Solution {
    public boolean isPalindrome(String s) {
        String str = "";

        for(int i=0 ; i<s.length() ; i++){
            char ch = s.charAt(i);

            if(Character.isLetterOrDigit(ch)){
                str += Character.toLowerCase(ch);
            }
        }
        String rv = "";

        for(int i=str.length()-1 ; i>=0 ; i--){
            rv += str.charAt(i);
        }
        return str.equals(rv);
    }
}