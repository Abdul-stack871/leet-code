// Last updated: 9/8/2026, 10:22:54 AM
1class Solution {
2    public int countCommas(int n) {
3        int cnt = 0 ; 
4
5        for(int i=1 ; i<=n ; i++){
6            if(i >= 1000){
7                cnt++ ;
8            }
9        }
10
11        return cnt ;
12    }
13}