// Last updated: 7/16/2026, 2:28:27 PM
1class Solution {
2    public boolean isValid(String s) {
3        Stack<Character> stack = new Stack<>();
4        for (char ch : s.toCharArray()) {
5            if (ch == '(' || ch == '[' || ch == '{') {
6                stack.push(ch);
7            } else {
8                if (stack.isEmpty()) {
9                    return false;
10                }
11                char top = stack.pop();
12                if (ch == ')' && top != '(') {
13                    return false;
14                }
15                if (ch == ']' && top != '[') {
16                    return false;
17                }
18                if (ch == '}' && top != '{') {
19                    return false;
20                }
21            }
22        }
23        return stack.isEmpty();
24    }
25}