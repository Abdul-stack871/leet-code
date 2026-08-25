// Last updated: 8/25/2026, 10:33:39 AM
1class Solution {
2    public int missingMultiple(int[] nums, int k) {
3        Set<Integer> sn = new HashSet<>();
4        for(int nm : nums){
5            sn.add(nm);
6        }
7
8        int cr = k ;
9
10        while(sn.contains(cr)){
11            cr += k ;
12        }
13
14        return cr ;
15    }
16}