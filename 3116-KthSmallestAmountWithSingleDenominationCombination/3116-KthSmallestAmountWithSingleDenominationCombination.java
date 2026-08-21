// Last updated: 8/21/2026, 11:46:59 AM
1import java.util.ArrayList;
2import java.util.Arrays;
3import java.util.List;
4
5class Solution {
6    public long findKthSmallest(int[] coins, int k) {
7        Arrays.sort(coins);
8        
9        List<Integer> newCoins = new ArrayList<>();
10        for (int x : coins) {
11            boolean keep = true;
12            for (int y : newCoins) {
13                if (x % y == 0) {
14                    keep = false;
15                    break;
16                }
17            }
18            if (keep) {
19                newCoins.add(x);
20            }
21        }
22        
23        int n = newCoins.size();
24        int m = 1 << n;
25        long[] lcm = new long[m];
26        Arrays.fill(lcm, 1);
27        
28        long left = k;
29        long right = (long) newCoins.get(0) * k + 1;
30        
31        for (int mask = 1; mask < m; mask++) {
32            int prevMask = mask & (mask - 1);
33            int bit = mask & -mask;
34            int i = Integer.numberOfTrailingZeros(bit);
35            
36            long temp = lcm[prevMask] / gcd(lcm[prevMask], newCoins.get(i));
37            
38            if (temp <= right / newCoins.get(i)) {
39                lcm[mask] = temp * newCoins.get(i);
40            } else {
41                lcm[mask] = right + 1;
42            }
43        }
44        
45        while (left < right) {
46            long mid = left + (right - left) / 2;
47            if (countLEQ(mid, lcm, m) >= k) {
48                right = mid;
49            } else {
50                left = mid + 1;
51            }
52        }
53        
54        return left;
55    }
56    
57    private long countLEQ(long x, long[] lcm, int m) {
58        long count = 0;
59        for (int mask = 1; mask < m; mask++) {
60            if (lcm[mask] > x) {
61                continue;
62            }
63            if (Integer.bitCount(mask) % 2 == 1) {
64                count += x / lcm[mask];
65            } else {
66                count -= x / lcm[mask];
67            }
68        }
69        return count;
70    }
71    
72    private long gcd(long a, long b) {
73        while (b != 0) {
74            long temp = a % b;
75            a = b;
76            b = temp;
77        }
78        return a;
79    }
80}