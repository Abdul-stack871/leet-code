# Last updated: 8/7/2026, 11:19:58 AM
1class Solution:
2    def containsNearbyAlmostDuplicate(self, nums, k, t):
3        if t < 0: 
4            return False
5        n = len(nums)
6        d = {}
7        w = t + 1
8        for i in range(n):
9            m = nums[i] // w
10            if m in d:
11                return True
12            if m - 1 in d and abs(nums[i] - d[m - 1]) < w:
13                return True
14            if m + 1 in d and abs(nums[i] - d[m + 1]) < w:
15                return True
16            d[m] = nums[i]
17            if i >= k:
18                del d[nums[i - k] // w]
19        return False