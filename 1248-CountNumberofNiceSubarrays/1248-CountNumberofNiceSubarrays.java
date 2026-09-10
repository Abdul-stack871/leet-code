// Last updated: 9/10/2026, 11:46:40 AM
1class Solution {
2    public int numberOfSubarrays(int[] nums, int k) {
3        int st = 0 , ed = 0;
4        int rs = 0 ;
5        int od = 0 ;
6
7        while(ed < nums.length){
8            if(nums[ed] % 2 == 1){
9                od++ ;
10            }
11
12            if(od == k){
13                int lftct = 1;
14                while(st <= ed && nums[st++] % 2 == 0){
15                    lftct++ ;
16                }
17
18                od-- ;
19                int rgtct = 1;
20                while(ed + 1 < nums.length && nums[ed + 1] % 2 == 0){
21                    rgtct++ ;
22                    ed++ ;
23                }
24
25                rs += lftct * rgtct ;
26
27            }
28            ed++ ;
29        }
30
31        return rs ;
32    }
33}