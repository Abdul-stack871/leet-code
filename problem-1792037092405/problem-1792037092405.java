// Last updated: 10/15/2026, 9:34:52 AM
1class Solution {
2    public int sumCounts(List<Integer> nums) {
3        int sum = 0;
4        int n = nums.size();      
5
6        for (int i = 0; i < n; i++) {
7            Set<Integer> set = new HashSet<>();
8
9            for (int j = i; j < n; j++) {
10                set.add(nums.get(j));
11
12                int distinct = set.size();
13                sum += (long) distinct * distinct;
14            }
15        }
16
17        return sum;
18        
19    }
20}