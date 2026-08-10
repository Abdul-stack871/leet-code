// Last updated: 8/10/2026, 10:58:01 AM
1class Solution {
2    public String simplifyPath(String path) {
3        String[] components = path.split("/");
4        Stack<String> st = new Stack<>();
5
6        for (String comp : components) {
7            if (comp.equals("") || comp.equals(".")) {
8                continue;
9            }
10
11            if (comp.equals("..")) {
12                if (!st.isEmpty()) {
13                    st.pop();
14                }
15            } else {
16                st.push(comp);
17            }
18        }
19
20        StringBuilder sb = new StringBuilder();
21        while (!st.isEmpty()) {
22            sb.insert(0, "/" + st.pop());
23        }
24
25        return sb.length() == 0 ? "/" : sb.toString();        
26    }
27}