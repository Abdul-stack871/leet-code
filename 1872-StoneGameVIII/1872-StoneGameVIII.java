// Last updated: 8/24/2026, 11:33:16 AM
1class Solution {
2    public int stoneGameVIII(int[] stones) {
3        
4        int x = stones.length ;
5
6        for(int i=1 ; i<x ; i++){
7            stones[i] += stones[i - 1];
8        }
9
10        int bst = stones[x - 1];
11
12        for(int i = x-2 ; i>= 1 ; i--){
13            bst = Math.max(bst, stones[i] - bst);
14        }
15
16        return bst ;
17    }
18}