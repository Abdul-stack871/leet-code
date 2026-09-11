// Last updated: 9/11/2026, 10:25:01 AM
1class Solution {
2    public int totalNumbers(int[] digits) {
3        int[] digitFreq = new int[10];
4        for (int digit : digits) {
5            digitFreq[digit]++;
6        }
7        
8        int ans = 0;
9        for (int i = 100; i < 999; i += 2) {
10            int num = i;
11            HashMap<Integer, Integer> map = new HashMap<>();
12            
13            while (num > 0) {
14                int rem = num % 10;
15                map.put(rem, map.getOrDefault(rem, 0) + 1);
16                num = num / 10;
17            }
18            
19            boolean flag = true;
20            for (int d : map.keySet()) {
21                if (digitFreq[d] < map.get(d)) {
22                    flag = false;
23                    break;
24                }
25            }
26            
27            if (flag) ans++;
28        }
29        return ans;
30    }
31}