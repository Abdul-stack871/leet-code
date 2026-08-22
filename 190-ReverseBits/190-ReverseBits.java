// Last updated: 8/22/2026, 10:14:45 AM
1class Solution {
2    public int reverseBits(int n) {
3        int rs = 0 ; 
4        for (int i=0 ; i<32 ; i++){
5            rs <<= 1 ;
6            rs |= (n & 1);
7            n >>>= 1 ;
8        }
9        return rs ;
10    }
11}