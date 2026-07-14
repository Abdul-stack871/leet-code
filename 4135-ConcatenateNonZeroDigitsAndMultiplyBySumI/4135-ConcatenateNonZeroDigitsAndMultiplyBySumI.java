// Last updated: 7/14/2026, 2:22:50 PM
class Solution {
    public long sumAndMultiply(int n) {
        long nnm = 0;
        long rv = 0;
        int sum = 0;

        while(n>0){
            int dg = n % 10 ;

            if(dg != 0){
                sum += dg ;
                nnm = nnm * 10 + dg ;
            }

            n = n/10 ;
        }

        while(nnm > 0){
            int dgt = (int)(nnm % 10);

            rv = rv * 10 + dgt ;

            nnm = nnm / 10;
        }

        return rv * sum ;
    }
}