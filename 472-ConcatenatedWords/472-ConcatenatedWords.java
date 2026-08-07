// Last updated: 8/7/2026, 2:33:33 PM
1import java.util.*;
2
3class Solution {
4    public List<String> findAllConcatenatedWordsInADict(String[] words) {
5        Set<String> s = new HashSet<>();
6        for (String word : words) {
7            s.add(word);
8        }
9        
10        List<String> concatenateWords = new ArrayList<>();
11        Map<String, Boolean> memo = new HashMap<>();
12        
13        for (String word : words) {
14            if (checkConcatenate(word, s, memo)) {
15                concatenateWords.add(word);
16            }
17        }
18        
19        return concatenateWords;
20    }
21    
22    public boolean checkConcatenate(String word, Set<String> s, Map<String, Boolean> memo) {
23        if (memo.containsKey(word)) {
24            return memo.get(word);
25        }
26        
27        for (int i = 1; i < word.length(); i++) {
28            String prefixWord = word.substring(0, i);
29            String suffixWord = word.substring(i);
30            
31            if (s.contains(prefixWord) && (s.contains(suffixWord) || checkConcatenate(suffixWord, s, memo))) {
32                memo.put(word, true);
33                return true;
34            }
35        }
36        
37        memo.put(word, false);
38        return false;
39    }
40}