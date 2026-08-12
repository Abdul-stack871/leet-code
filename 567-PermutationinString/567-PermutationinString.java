// Last updated: 8/12/2026, 11:46:21 AM
1class Solution {
2    public static String sorted(String s) {
3        char[] arr = s.toCharArray();
4        Arrays.sort(arr);
5        return new String(arr);
6    }
7
8    public boolean checkInclusion(String s1, String s2) {
9        int right = 0, left = 1;
10        int k = s1.length();
11        s1 = sorted(s1);
12        if (s1.length() > s2.length()) {
13            return false;
14        }
15
16        if (s1.equals(sorted(s2.substring(0, k)))) {
17            return true;
18        }
19
20        for (int i = k; i < s2.length(); i++) {
21            if (s1.equals(sorted(s2.substring(left, i + 1)))) {
22                return true;
23            } else {
24                left++;
25            }
26        }
27        return false;
28    }
29}