// Last updated: 8/22/2026, 12:26:45 PM
1class Solution {
2    public int splitArray(int[] nums, int k) {
3
4        int low = 0;
5        int high = 0;
6
7        for (int num : nums) {
8            low = Math.max(low, num);
9            high += num;
10        }
11
12        while (low <= high) {
13
14            int mid = low + (high - low) / 2;
15
16            if (canSplit(nums, k, mid)) {
17                high = mid - 1;
18            } else {
19                low = mid + 1;
20            }
21        }
22
23        return low;
24    }
25
26    private boolean canSplit(int[] nums, int k, int maxSum) {
27
28        int count = 1;
29        int sum = 0;
30
31        for (int num : nums) {
32
33            if (sum + num > maxSum) {
34                count++;
35                sum = num;
36            } else {
37                sum += num;
38            }
39        }
40
41        return count <= k;
42    }
43}