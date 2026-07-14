// Last updated: 7/14/2026, 2:25:22 PM
class Solution {
    public boolean isHappy(int n) {
        while(n != 1 && n != 4){
            int sum = 0 ;

            while(n > 0){
                int dg = n % 10 ;

                sum += dg * dg ;

                n = n/10 ;


            }
             n = sum ;
        }

        return n == 1;
        
    }
}