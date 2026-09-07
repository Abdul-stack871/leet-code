// Last updated: 9/7/2026, 11:00:45 AM
1class Solution {
2    public boolean isPerfectSquare(int num) {
3        long lw = 1;
4        long high = num ; 
5        while(lw <= high ){
6            long md = lw +(high - lw) / 2;
7            long sq = md * md ;
8            if(sq == num) return true ;
9            if(sq < num) lw = md + 1;
10            else high = md - 1 ;
11
12        }
13
14        return false ;
15    }
16}