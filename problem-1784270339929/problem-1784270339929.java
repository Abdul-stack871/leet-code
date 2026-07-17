// Last updated: 7/17/2026, 12:08:59 PM
1import java.util.*;
2
3class Solution {
4    public int[] gcdValues(int[] nums, long[] queries) {
5        int max = 0;
6        for (int x : nums) max = Math.max(max, x);
7
8        int[] freq = new int[max + 1];
9        for (int x : nums) freq[x]++;
10
11        long[] multiples = new long[max + 1];
12        for (int g = max; g >= 1; g--) {
13            long cnt = 0;
14            for (int m = g; m <= max; m += g) {
15                cnt += freq[m];
16            }
17            multiples[g] = cnt;
18        }
19
20        long[] exact = new long[max + 1];
21        for (int g = max; g >= 1; g--) {
22            long total = multiples[g] * (multiples[g] - 1) / 2;
23            for (int m = 2 * g; m <= max; m += g) {
24                total -= exact[m];
25            }
26            exact[g] = total;
27        }
28
29        long[] pref = new long[max + 1];
30        for (int g = 1; g <= max; g++) {
31            pref[g] = pref[g - 1] + exact[g];
32        }
33
34        int[] ans = new int[queries.length];
35        for (int i = 0; i < queries.length; i++) {
36            long k = queries[i] + 1;
37            int lo = 1, hi = max;
38            while (lo < hi) {
39                int mid = (lo + hi) >>> 1;
40                if (pref[mid] >= k) hi = mid;
41                else lo = mid + 1;
42            }
43            ans[i] = lo;
44        }
45        return ans;
46    }
47}