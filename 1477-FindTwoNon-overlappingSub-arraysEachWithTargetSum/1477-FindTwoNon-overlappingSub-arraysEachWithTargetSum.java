// Last updated: 9/17/2026, 10:36:03 AM
1class Solution {
2    public int minSumOfLengths(int[] arr, int target) {
3        int n = arr.length;
4        int[] best = new int[n];
5        int left = 0, sum = 0;
6        int ans = Integer.MAX_VALUE;
7        int minLen = Integer.MAX_VALUE;
8        
9        for (int right = 0; right < n; right++) {
10            sum += arr[right];
11            
12            while (sum > target) {
13                sum -= arr[left++];
14            }
15            
16            if (sum == target) {
17                int len = right - left + 1;
18                if (left > 0 && best[left - 1] != Integer.MAX_VALUE) {
19                    ans = Math.min(ans, len + best[left - 1]);
20                }
21                minLen = Math.min(minLen, len);
22            }
23            best[right] = minLen;
24        }
25        
26        return ans == Integer.MAX_VALUE ? -1 : ans;
27    }
28}