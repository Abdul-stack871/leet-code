// Last updated: 7/14/2026, 2:27:21 PM
class Solution {
    public boolean isPalindrome(int x) {
     if(x < 0){
        return false ;
     }   

     int reverse  = 0 ;
     int xcopy = x ;

     while (x>0){
        reverse  = (reverse * 10) + (x % 10);
        x /= 10 ;
     }


     return  reverse  == xcopy ;
    }
}