// Last updated: 9/29/2026, 10:28:18 AM
1class Solution {
2    public List<String> summaryRanges(int[] nums) {
3        List<String> ans = new ArrayList<>();
4        int n = nums.length;
5        int i = 0;
6
7        while(i < n) {
8            int start = nums[i];
9
10            while(i < n - 1 && nums[i] + 1 == nums[i + 1])
11                i++;
12
13            int end = nums[i];
14
15            if(start == end)
16                ans.add(String.valueOf(start));
17            else
18                ans.add(start + "->" + end);
19
20            i++;
21        }
22
23        return ans;
24    }
25}