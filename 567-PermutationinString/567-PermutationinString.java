// Last updated: 8/12/2026, 11:54:04 AM
1class Solution {
2    public boolean isVowel(char c){
3        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
4    }
5    public int maxVowels(String s, int k) {
6        int maxVowel=0;
7        int left=0;
8        int vowel=0;
9        for(int right=0;right<s.length();right++){
10            if(isVowel(s.charAt(right)))vowel++;
11            if((right-left+1) == k){
12                maxVowel=Math.max(maxVowel,vowel);
13                if(isVowel(s.charAt(left)))vowel--;
14                left++;
15            }
16        }
17        return maxVowel;
18    }
19}