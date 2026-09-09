// Last updated: 9/9/2026, 10:03:21 AM
1class Solution {
2    public long countCommas(long n) {
3        long totalCommas = 0;
4        long low = 1000;
5        long commasPerNumber = 1;
6        
7        while (low <= n) {
8            long high = Math.min(n, (low * 1000) - 1);
9            long count = high - low + 1;
10            totalCommas += count * commasPerNumber;
11            
12            low *= 1000;
13            commasPerNumber++;
14        }
15        
16        return totalCommas;
17    }
18}