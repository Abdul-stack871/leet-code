// Last updated: 9/15/2026, 11:35:11 AM
1class Solution {
2    public boolean isValid(String code) {
3        int[] i = {0};
4        return validTag(code, i) && i[0] == code.length();
5    }
6    
7    private boolean validTag(String s, int[] i) {
8        int[] j = {i[0]};
9        String tag = parseTagName(s, j);
10        if (tag.isEmpty()) return false;
11        if (!validContent(s, j)) return false;
12        int k = j[0] + tag.length() + 2;
13        if (k >= s.length() || !s.substring(j[0], k + 1).equals("</" + tag + ">")) return false;
14        i[0] = k + 1;
15        return true;
16    }
17    
18    private String parseTagName(String s, int[] i) {
19        if (i[0] >= s.length() || s.charAt(i[0]) != '<') return "";
20        int j = s.indexOf('>', i[0]);
21        int len = j - 1 - i[0];
22        if (j == -1 || len < 1 || len > 9) return "";
23        String tag = s.substring(i[0] + 1, j);
24        for (char ch : tag.toCharArray()) {
25            if (ch < 'A' || ch > 'Z') return "";
26        }
27        i[0] = j + 1;
28        return tag;
29    }
30    
31    private boolean validContent(String s, int[] i) {
32        while (i[0] < s.length()) {
33            if (!validText(s, i) && !validCData(s, i) && !validTag(s, i)) break;
34        }
35        return true;
36    }
37    
38    private boolean validText(String s, int[] i) {
39        int j = i[0];
40        while (i[0] < s.length() && s.charAt(i[0]) != '<') {
41            i[0]++;
42        }
43        return i[0] != j;
44    }
45    
46    private boolean validCData(String s, int[] i) {
47        if (!s.startsWith("<![CDATA[", i[0])) return false;
48        int j = s.indexOf("]]>", i[0]);
49        if (j == -1) return false;
50        i[0] = j + 3;
51        return true;
52    }
53}