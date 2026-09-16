// Last updated: 9/16/2026, 3:02:24 PM
1class Solution {
2    public int numberOfSets(int n, int k) {
3        long res = 1;
4        long mod = 1000000007;
5        
6        int totalPoints = n + k - 1;
7        int pointsToPick = 2 * k;
8        
9        if (pointsToPick > totalPoints) return 0;
10        
11        for (int i = 1; i <= pointsToPick; i++) {
12            res = res * (totalPoints - i + 1) % mod;
13            res = res * power(i, mod - 2, mod) % mod; 
14        }
15        
16        return (int) res;
17    }
18
19    private long power(long base, long exp, long mod) {
20        long res = 1;
21        while (exp > 0) {
22            if (exp % 2 == 1) res = (res * base) % mod;
23            base = (base * base) % mod;
24            exp /= 2;
25        }
26        return res;
27    }
28}