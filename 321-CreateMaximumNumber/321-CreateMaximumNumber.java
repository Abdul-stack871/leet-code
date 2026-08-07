// Last updated: 8/7/2026, 11:41:36 AM
1class Solution {
2    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
3    int n = nums1.length;
4    int m = nums2.length;
5    int[] ans = new int[k];
6    for (int i = Math.max(0, k - m); i <= k && i <= n; ++i) {
7        int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
8        if (greater(candidate, 0, ans, 0)) ans = candidate;
9    }
10    return ans;
11}
12private int[] merge(int[] nums1, int[] nums2, int k) {
13    int[] ans = new int[k];
14    for (int i = 0, j = 0, r = 0; r < k; ++r)
15        ans[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
16    return ans;
17}
18public boolean greater(int[] nums1, int i, int[] nums2, int j) {
19    while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
20        i++;
21        j++;
22    }
23    return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
24}
25public int[] maxArray(int[] nums, int k) {
26    int n = nums.length;
27    int[] ans = new int[k];
28    for (int i = 0, j = 0; i < n; ++i) {
29        while (n - i + j > k && j > 0 && ans[j - 1] < nums[i]) j--;
30        if (j < k) ans[j++] = nums[i];
31    }
32    return ans;
33}
34}