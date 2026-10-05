// Last updated: 10/5/2026, 8:35:05 AM
1class Solution {
2    public int scoreOfParentheses(String s) {
3        java.util.Stack<Integer> stack = new java.util.Stack<>();
4        stack.push(0);
5        
6        for (char ch : s.toCharArray()) {
7            if (ch == '(') {
8                stack.push(0);
9            } else {
10                int val = Math.max(2 * stack.pop(), 1);
11                stack.push(stack.pop() + val);
12            }
13        }
14        
15        return stack.pop();
16    }
17}