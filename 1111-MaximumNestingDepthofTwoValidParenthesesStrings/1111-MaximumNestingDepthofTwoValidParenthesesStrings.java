// Last updated: 9/30/2026, 11:53:25 AM
1class Solution {
2    public int[] maxDepthAfterSplit(String seq) {
3        int x = seq.length() ;
4
5        int[] rs = new int[x];
6
7        int dpt = 0 ;
8
9        for(int i=0 ; i<x ; i++){
10
11            if(seq.charAt(i) == '('){
12                dpt++ ;
13                rs[i] = dpt % 2 ;
14            }else{
15                rs[i] = dpt % 2 ;
16                dpt-- ;
17            }
18        }
19        return rs ;
20    }
21}