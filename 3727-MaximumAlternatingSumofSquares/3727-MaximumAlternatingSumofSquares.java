// Last updated: 10/13/2026, 9:35:57 AM
1import java.util.*;
2
3class Solution {
4    public long maxAlternatingSum(int[] nums) {
5        int n = nums.length ;
6
7
8
9
10        for(int i=0 ; i<n ; i++){
11            nums[i] *= nums[i] ;
12        }
13
14        Arrays.sort(nums);
15
16        long rs = 0 ;
17        int md = n/2  ;
18
19        for(int i=0 ; i<md ; i++){
20            rs -= nums[i];
21        }
22
23        for(int i=md ; i<n ; i++){
24            rs += nums[i];
25        }
26
27        return rs ;
28    }
29}