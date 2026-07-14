// Last updated: 7/14/2026, 2:26:48 PM
class Solution {
    public double myPow(double x, int n) {
        if(n<0){
            n = -n ;
            x = 1/x ;
        }

        double pow = 1;

        while(n != 0){
            if((n & 1) != 0){
                pow *= x ;
            }

            x *= x;
             n >>>= 1;
        }

        return pow ;
    }
}