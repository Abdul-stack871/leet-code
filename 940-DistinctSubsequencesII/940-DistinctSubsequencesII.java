// Last updated: 9/7/2026, 8:56:40 AM
1class Solution {
2    public int distinctSubseqII(String s) {
3        final long md = 1000000007L;
4
5        long pd = 1 ;
6        long[] lst = new long[26];
7
8        for(char c : s.toCharArray()){
9            int idx = c - 'a';
10
11            long oldpd = pd ;
12
13
14            pd = (2 * pd - lst[idx] + md) % md ;
15
16
17            lst[idx] = oldpd ;
18
19        }
20
21
22        return(int)((pd - 1 + md) % md);
23    }
24}