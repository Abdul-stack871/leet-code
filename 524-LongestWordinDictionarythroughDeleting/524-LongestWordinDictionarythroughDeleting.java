// Last updated: 8/22/2026, 10:28:24 AM
1class Solution {
2    public String findLongestWord(String S, List<String> D) {
3        String ans = "";
4        for (String word : D) {
5            int a = word.length(), b = ans.length();
6            if (a < b || (a == b && word.compareTo(ans) > 0)) continue;
7            int pos = -1;
8            for (int i = 0; i < a; i++) {
9                pos = S.indexOf(word.charAt(i), pos + 1);
10                if (pos == -1) break;
11            }
12            if (pos != -1) ans = word;
13        }
14        return ans;
15    }
16}