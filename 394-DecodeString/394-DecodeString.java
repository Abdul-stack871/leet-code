// Last updated: 7/14/2026, 2:50:56 PM
1class Solution {
2    public String decodeString(String s) {
3        if (s == null || s.length() == 0) return s;
4        
5        int currNum = 0;
6        Stack<Integer> intStack = new Stack<>();
7        Stack<String> strStack = new Stack<>();
8
9        for (char x : s.toCharArray()) {
10            if (x >= '0' && x <= '9') {
11                currNum = (currNum * 10) + (x - '0');
12            } else {
13                if (x == '[') {
14                    intStack.push(currNum);
15                    currNum = 0;
16                    strStack.push(String.valueOf(x));
17                } else if (x == ']') {
18                    String temp = "";
19                    while (!strStack.isEmpty() && !strStack.peek().equals("[")) {
20                        temp = strStack.pop() + temp;
21                    }
22                    strStack.pop(); // Remove "["
23                    
24                    int num = intStack.pop();
25                    StringBuilder tempAns = new StringBuilder();
26                    for (int i = 0; i < num; ++i) {
27                        tempAns.append(temp);
28                    }
29                    strStack.push(tempAns.toString());
30                } else {
31                    strStack.push(String.valueOf(x));
32                }
33            }
34        }
35        
36        String ans = "";
37        while (!strStack.isEmpty()) {
38            ans = strStack.pop() + ans;
39        }
40        return ans;
41    }
42}