// Last updated: 7/14/2026, 2:25:06 PM
class Solution {
    public int addDigits(int num) {
        if( num == 0)
             return 0;
        if(num % 9 == 0)
             return 9;
        return num % 9 ;
    }
}