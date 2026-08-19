// Last updated: 8/19/2026, 11:26:15 AM
1import java.util.HashMap;
2import java.util.Map;
3
4public class Solution {
5    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
6        Map<Integer, Integer> graph = new HashMap<>();
7        for (int[] seat : reservedSeats) {
8            int row = seat[0];
9            int col = seat[1];
10            if (col >= 2 && col <= 9) {
11                int mask = graph.getOrDefault(row, 0);
12                mask |= (1 << (col - 2));
13                graph.put(row, mask);
14            }
15        }
16        
17        // Base case: Assume 2 families per empty row
18        int maxFamilies = 2 * n;
19        
20        for (int mask : graph.values()) {
21            boolean left = (mask & 15) == 0;   
22            boolean right = (mask & 240) == 0; 
23            boolean mid = (mask & 60) == 0;    
24            
25            maxFamilies -= 2; 
26            
27            if (left && right) {
28                maxFamilies += 2;
29            } else if (left || right || mid) {
30                maxFamilies += 1;
31            }
32        }
33        
34        return maxFamilies;
35    }
36}