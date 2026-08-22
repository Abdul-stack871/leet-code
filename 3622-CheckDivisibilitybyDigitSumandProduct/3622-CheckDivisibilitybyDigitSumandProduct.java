// Last updated: 8/22/2026, 9:36:10 AM
1class Solution {
2    public boolean checkDivisibility(int n) {
3        int org = n ;
4        int dgtsm = 0 ;
5        int dgtprd = 1 ;
6
7        while(n > 0){
8            int dgt = n % 10 ;
9
10            dgtsm += dgt ;
11            dgtprd *= dgt ;
12            n /=  10 ;
13        }   
14
15
16        int dvs = dgtsm + dgtprd ;
17        return org % dvs == 0 ;
18    }
19}