// Last updated: 7/14/2026, 2:26:45 PM
class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0 ;
    boolean charfound = false ;
    for(int i=s.length()-1 ; i>=0 ; i--){
        if(s.charAt(i) == ' '){
            if(charfound ) return len ;
            continue ;
        }

        len++ ;
        charfound = true ;
    }

    return len ;
    }
}