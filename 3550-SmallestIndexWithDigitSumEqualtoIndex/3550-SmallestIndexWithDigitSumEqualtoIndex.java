// Last updated: 9/24/2026, 11:42:34 AM
1class Solution {
2    public int smallestIndex(int[] nums) {
3        
4        for(int i=0 ; i<nums.length ; i++){
5            if(checksum(nums[i]) == i)
6                 return i;
7        }
8        return -1 ;
9    }
10
11    public int checksum(int nm){
12        int sm = 0 ;
13
14        while(nm != 0){
15            sm = sm + nm % 10 ;
16            nm /= 10 ;
17        }
18
19        return sm ; 
20    }
21}