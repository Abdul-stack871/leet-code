# Last updated: 7/14/2026, 2:24:33 PM
class Solution(object):
    def intersection(self, nums1, nums2):
        flag = [False] * 1001

        for num in nums1:
            flag[num] = True

        ans = []
        for num in nums2:
            if flag[num]:
                ans.append(num)
                flag[num] = False 

        return ans        