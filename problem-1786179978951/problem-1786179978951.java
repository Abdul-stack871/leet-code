// Last updated: 8/8/2026, 2:36:18 PM
1
2class Solution {
3    public int[] validSequence(String word1, String word2) {
4        int n = word1.length(), m = word2.length();
5        int[] dp = new int[n + 1];
6        int j = m - 1;
7
8        for (int i = n - 1; i >= 0; i--) {
9            dp[i] = dp[i + 1];
10
11            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
12                dp[i]++;
13                j--;
14            }
15        }
16
17        int[] ans = new int[m];
18        int k = 0;
19        int i = 0;
20
21        while (i < n && k < m) {
22
23            if (word1.charAt(i) == word2.charAt(k)) {
24                ans[k++] = i;
25            }
26
27            else if (dp[i + 1] >= m - k - 1) {
28                ans[k++] = i;
29
30                i++;
31
32                while (i < n && k < m) {
33                    if (word1.charAt(i) == word2.charAt(k)) {
34                        ans[k++] = i;
35                    }
36                    i++;
37                }
38
39                break;
40            }
41
42            i++;
43        }
44
45        return k == m ? ans : new int[0];
46    }
47}