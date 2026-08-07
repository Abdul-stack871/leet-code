// Last updated: 8/7/2026, 2:31:23 PM
1import java.util.HashMap;
2import java.util.Map;
3
4class Solution {
5    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
6        Map<Integer, Integer> map = new HashMap<>();
7        int cnt = 0;
8
9        for (int i : nums1) {
10            for (int j : nums2) {
11                map.put(i + j, map.getOrDefault(i + j, 0) + 1);
12            }
13        }
14
15        for (int k : nums3) {
16            for (int l : nums4) {
17                cnt += map.getOrDefault(-(k + l), 0);
18            }
19        }
20
21        return cnt;
22    }
23}