// Last updated: 7/14/2026, 2:23:41 PM
class Solution {
    public int consecutiveNumbersSum(int n) {
        int cnt = 0 ; 
        for(int k=1 ;2*n>(k*(k-1)) ; k++){
            int numter = n-(k*(k-1)) / 2 ;
            int demon = k ;
            if(numter % demon == 0){
                cnt++ ;
            } 
        }
        return cnt ;
    }
}