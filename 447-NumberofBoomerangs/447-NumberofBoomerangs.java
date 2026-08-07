// Last updated: 8/7/2026, 12:06:21 PM
1class Solution {
2    public int numberOfBoomerangs(int[][] points) {
3        int n = points.length;
4        int cnt = 0;
5        
6        for(int i = 0; i < n; i++) {
7            HashMap<Long, Integer> hn = new HashMap<>();
8            
9            for(int j = 0; j < n; j++) {
10                if(i == j) continue;
11                
12                int y = points[i][1] - points[j][1];
13                int x = points[i][0] - points[j][0];
14                long key = (long) y * y + (long) x * x;
15                
16                hn.put(key, hn.getOrDefault(key, 0) + 1);
17            }
18            
19            for(Map.Entry<Long, Integer> u : hn.entrySet()) {
20                int kt = u.getValue();
21                if(kt > 1) {
22                    cnt += kt * (kt - 1);
23                }
24            }
25        } 
26        
27        return cnt; 
28    }
29}