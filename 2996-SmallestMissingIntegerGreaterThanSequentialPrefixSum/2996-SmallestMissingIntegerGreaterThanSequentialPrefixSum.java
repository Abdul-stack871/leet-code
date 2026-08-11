// Last updated: 8/11/2026, 10:32:11 AM
1class Solution {
2    public int missingInteger(int[] nums) {
3        
4        int sm = nums[0];
5       for(int i = 1; i < nums.length; i++) {
6    if(nums[i] == (nums[i-1] + 1)) {
7        sm += nums[i];
8    } else {
9        break;
10    }
11}
12
13        Set<Integer> s = new HashSet<>();
14        for(int i : nums){
15            if(i >= sm){
16                s.add(i);
17            }
18        }
19
20        while(s.contains(sm)){
21            sm++;
22        }
23        return sm ;
24    }
25}