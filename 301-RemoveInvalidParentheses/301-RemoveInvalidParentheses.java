// Last updated: 10/7/2026, 11:28:25 AM
1import java.util.*;
2
3class Solution {
4
5    List<String> result = new ArrayList<>();
6    Set<String> set = new HashSet<>();
7
8    public List<String> removeInvalidParentheses(String s) {
9
10        int left = 0;
11        int right = 0;
12
13        for (char c : s.toCharArray()) {
14
15            if (c == '(') {
16                left++;
17            } 
18            else if (c == ')') {
19
20                if (left > 0) {
21                    left--;
22                } 
23                else {
24                    right++;
25                }
26            }
27        }
28
29        remove(s, 0, left, right);
30
31        return result;
32    }
33
34    void remove(String s, int index, int left, int right) {
35
36        if (left == 0 && right == 0) {
37
38            if (isValid(s) && !set.contains(s)) {
39                result.add(s);
40                set.add(s);
41            }
42
43            return;
44        }
45
46        for (int i = index; i < s.length(); i++) {
47
48            if (s.charAt(i) != '(' && s.charAt(i) != ')') {
49                continue;
50            }
51
52            String newString =
53                s.substring(0, i) + s.substring(i + 1);
54
55            if (s.charAt(i) == '(' && left > 0) {
56                remove(newString, i, left - 1, right);
57            }
58
59            if (s.charAt(i) == ')' && right > 0) {
60                remove(newString, i, left, right - 1);
61            }
62        }
63    }
64
65    boolean isValid(String s) {
66
67        int count = 0;
68
69        for (char c : s.toCharArray()) {
70
71            if (c == '(') {
72                count++;
73            }
74
75            if (c == ')') {
76                count--;
77            }
78
79            if (count < 0) {
80                return false;
81            }
82        }
83
84        return count == 0;
85    }
86}