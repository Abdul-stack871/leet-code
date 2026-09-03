// Last updated: 9/3/2026, 11:40:19 AM
1class Solution {
2    public boolean uniformArray(int[] nums1) {
3        int smlod = Integer.MAX_VALUE;
4        
5        for(int nm : nums1) {
6            if(nm % 2 == 1)
7                smlod = Math.min(smlod, nm);
8        }
9        
10        if(smlod == Integer.MAX_VALUE)
11            return true;
12            
13        for(int nm : nums1) {
14            if(nm % 2 == 0 && nm <= smlod)
15                return false;
16        }
17        
18        return true;
19    }
20}