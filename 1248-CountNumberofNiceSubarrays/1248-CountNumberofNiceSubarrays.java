// Last updated: 9/10/2026, 11:56:47 AM
1class Solution {
2    public int maxScore(int[] nums, int k) {
3        int n = nums.length;
4        int lsm = 0 ; 
5        int rsm = 0 ; 
6        int mxsm = 0 ; 
7        for(int i=0 ; i<k ; i++){
8            lsm = lsm + nums[i];
9        }
10
11
12        mxsm = lsm ;
13        int rd = n-1 ;
14        for(int i=k-1 ; i>=0 ; i--){
15            lsm = lsm - nums[i];
16            rsm = rsm + nums[rd];
17            mxsm = Math.max(mxsm,lsm+rsm);
18            rd-- ;
19        }
20
21        return mxsm ;
22    }
23}