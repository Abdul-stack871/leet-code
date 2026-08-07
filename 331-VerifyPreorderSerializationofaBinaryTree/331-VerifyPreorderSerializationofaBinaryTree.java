// Last updated: 8/7/2026, 11:16:25 AM
1class Solution {
2    public boolean isValidSerialization(String preorder) {
3
4        Stack<String>  st = new Stack<>();
5
6        int i=0 ;
7        while(i < preorder.length()){
8            int j=i ; 
9            while(j < preorder.length() && preorder.charAt(j) != ','){
10                j++ ;
11            }
12
13            String s = preorder.substring(i, j);
14            if(!st.isEmpty()){
15                while(!st.isEmpty() && s.equals("#") && st.peek().equals("#")){
16                    st.pop();
17                    if(st.isEmpty()) return false ;
18                    st.pop();
19                }
20            }
21
22            st.push(s);
23            i = j + 1 ;
24        }
25
26        if(st.size() == 1 && st.peek().equals("#")){
27            return true ;
28        }
29
30        return false ;
31    }
32}