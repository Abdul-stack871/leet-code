// Last updated: 9/18/2026, 10:10:32 AM
1import java.util.ArrayList;
2import java.util.Arrays;
3import java.util.List;
4
5class Solution {
6    public List<String> maxNumOfSubstrings(String s) {
7        int n = s.length();
8        int[] left = new int[26];
9        int[] right = new int[26];
10        
11        Arrays.fill(left, n);
12        Arrays.fill(right, -1);
13        
14        for (int i = 0; i < n; i++) {
15            int c = s.charAt(i) - 'a';
16            left[c] = Math.min(left[c], i);
17            right[c] = i;
18        }
19        
20        List<String> result = new ArrayList<>();
21        int lastRight = -1; 
22        
23        for (int i = 0; i < n; i++) {
24            int c = s.charAt(i) - 'a';
25            
26            if (i == left[c]) {
27                int validRightBound = getValidRightBound(s, i, left, right);
28                
29                if (validRightBound != -1) {
30                    if (i > lastRight) {
31                       
32                        result.add(s.substring(i, validRightBound + 1));
33                    } else {
34                        result.set(result.size() - 1, s.substring(i, validRightBound + 1));
35                    }
36                    lastRight = validRightBound;
37                }
38            }
39        }
40        
41        return result;
42    }
43    
44    private int getValidRightBound(String s, int start, int[] left, int[] right) {
45        int currentRight = right[s.charAt(start) - 'a'];
46        
47        for (int i = start; i <= currentRight; i++) {
48            int c = s.charAt(i) - 'a';
49            
50          
51            if (left[c] < start) {
52                return -1; 
53            }
54            currentRight = Math.max(currentRight, right[c]);
55        }
56        return currentRight;
57    }
58}