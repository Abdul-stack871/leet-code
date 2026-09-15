// Last updated: 9/15/2026, 10:22:38 AM
1import java.util.*;
2
3class Solution {
4    public int maxPalindromes(String s, int k) {
5        List<int[]> intervals = new ArrayList<>();
6        int n = s.length();
7        
8        for (int i = 0; i < n; i++) {
9            expandAndCollect(s, i, i, k, intervals);
10            expandAndCollect(s, i, i + 1, k, intervals);
11        }
12        
13        Collections.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
14        
15        int count = 0;
16        int lastEnd = -1;
17        for (int[] interval : intervals) {
18            if (interval[0] > lastEnd) {
19                count++;
20                lastEnd = interval[1];
21            }
22        }
23        
24        return count;
25    }
26    
27    private void expandAndCollect(String s, int left, int right, int k, List<int[]> intervals) {
28        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
29            if (right - left + 1 >= k) {
30                intervals.add(new int[]{left, right});
31            }
32            left--;
33            right++;
34        }
35    }
36}