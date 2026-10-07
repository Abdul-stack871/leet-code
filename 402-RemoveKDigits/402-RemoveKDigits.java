// Last updated: 10/7/2026, 12:33:04 PM
1class Solution {
2    public String removeKdigits(String num, int k) {
3
4        StringBuilder sb = new StringBuilder();
5
6        for (char digit : num.toCharArray()) {
7
8            while (k > 0 &&
9                   sb.length() > 0 &&
10                   sb.charAt(sb.length() - 1) > digit) {
11
12                sb.deleteCharAt(sb.length() - 1);
13                k--;
14            }
15
16            sb.append(digit);
17        }
18
19        while (k > 0 && sb.length() > 0) {
20            sb.deleteCharAt(sb.length() - 1);
21            k--;
22        }
23
24        int i = 0;
25
26        while (i < sb.length() && sb.charAt(i) == '0') {
27            i++;
28        }
29
30        String result = sb.substring(i);
31
32        if (result.length() == 0) {
33            return "0";
34        }
35
36        return result;
37    }
38}