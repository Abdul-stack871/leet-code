// Last updated: 9/18/2026, 2:37:54 PM
1class Solution {
2    public String shortestPalindrome(String s) {
3        String rev_s = new StringBuilder(s).reverse().toString();
4        String temp = s + "#" + rev_s;
5        
6        int[] lps = new int[temp.length()];
7        
8        for (int i = 1; i < temp.length(); i++) {
9            int j = lps[i - 1];
10            
11            while (j > 0 && temp.charAt(i) != temp.charAt(j)) {
12                j = lps[j - 1];
13            }
14            
15            if (temp.charAt(i) == temp.charAt(j)) {
16                j++;
17            }
18            
19            lps[i] = j;
20        }
21        
22        int longestPalindromicPrefixLength = lps[temp.length() - 1];
23        
24        String suffixToAdd = s.substring(longestPalindromicPrefixLength);
25        return new StringBuilder(suffixToAdd).reverse().toString() + s;
26    }
27}