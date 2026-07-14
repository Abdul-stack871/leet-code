// Last updated: 7/14/2026, 2:25:07 PM
class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false ;
        }

        char[] ar1 = s.toCharArray();
        char[] ar2 = t.toCharArray();

        Arrays.sort(ar1);
        Arrays.sort(ar2);


        if(Arrays.equals(ar1,ar2)){
            return true ;
        } else {
            return false ;
        }
        
    }
}