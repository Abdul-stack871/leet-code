// Last updated: 10/9/2026, 10:24:40 AM
1class Solution {
2    public int minInsertions(String s) {
3        int ans = 0;
4        int right = 0; 
5
6        for (int i = 0; i < s.length(); i++) {
7            if (s.charAt(i) == '(') {
8               
9                if (right % 2 != 0) {
10                    ans++;
11                    right--;
12                }
13                right += 2;
14            } else {
15                right--;
16                if (right < 0) {
17                    ans++;
18                    right += 2; 
19                }
20            }
21        }
22
23        return ans + right;
24    }
25}