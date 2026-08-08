// Last updated: 8/8/2026, 2:51:07 PM
1class Solution {
2    public boolean isNumber(String s) {
3        s = s.trim();
4        
5        boolean pointSeen = false;
6        boolean eSeen = false;
7        boolean numberSeen = false;
8        boolean numberAfterE = true;
9        
10        for (int i = 0; i < s.length(); i++) {
11            if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
12                numberSeen = true;
13                numberAfterE = true;
14            } else if (s.charAt(i) == '.') {
15                if (eSeen || pointSeen) {
16                    return false;
17                }
18                pointSeen = true;
19            } else if (s.charAt(i) == 'e' || s.charAt(i) == 'E') { // Fixed: Added 'E'
20                if (eSeen || !numberSeen) {
21                    return false;
22                }
23                numberAfterE = false;
24                eSeen = true;
25            } else if (s.charAt(i) == '-' || s.charAt(i) == '+') {
26                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') { 
27                    return false;
28                }
29            } else {
30                return false;
31            }
32        }
33        
34        return numberSeen && numberAfterE;
35    }
36}