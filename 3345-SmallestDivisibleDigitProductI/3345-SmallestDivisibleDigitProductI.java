// Last updated: 8/6/2026, 12:16:10 PM
1class Solution {
2    public int smallestNumber(int n, int t) {
3        int q = n / 10, r = n % 10;
4
5        int req = t / gcd(q + (10 - q) / 10, t);
6        int nxt = ((r + req - 1) / req) * req;
7        int x = nxt - (nxt - 10) * (nxt / 10);
8
9        return q * 10 + x;
10    }
11
12    private int gcd(int a, int b) {
13        return (b == 0) ? a : gcd(b, a % b);
14    }
15}