// Last updated: 8/10/2026, 12:10:51 PM
1class Solution {
2    public List<String> findWords(char[][] board, String[] words) {
3        List<String> res = new ArrayList<>();
4        TrieNode root = buildTrie(words);
5        for (int i = 0; i < board.length; i++) {
6            for (int j = 0; j < board[0].length; j++) {
7                dfs(board, i, j, root, res);
8            }
9        }
10        return res;
11    }
12
13    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
14        char c = board[i][j];
15   
16        if (c == '#' || p.next[c - 'a'] == null) return;
17        
18        p = p.next[c - 'a'];
19        if (p.word != null) {   
20            res.add(p.word);
21            p.word = null;     
22        }
23
24        board[i][j] = '#';     
25        if (i > 0) dfs(board, i - 1, j, p, res);
26        if (j > 0) dfs(board, i, j - 1, p, res);
27        if (i < board.length - 1) dfs(board, i + 1, j, p, res);
28        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);
29        board[i][j] = c;        
30    }
31
32    public TrieNode buildTrie(String[] words) {
33        TrieNode root = new TrieNode();
34        for (String w : words) {
35            TrieNode p = root;
36            for (char c : w.toCharArray()) {
37                int i = c - 'a';
38                if (p.next[i] == null) p.next[i] = new TrieNode();
39                p = p.next[i];
40            }
41            p.word = w; 
42        }
43        return root;
44    }
45
46    class TrieNode {
47        TrieNode[] next = new TrieNode[26];
48        String word;
49    }
50}