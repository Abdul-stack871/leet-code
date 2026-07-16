// Last updated: 7/16/2026, 5:01:09 PM
1class Solution {
2    int count = 0 ;
3
4    public int totalNQueens(int n) {
5        char[][] board = new char[n][n];
6        nQueens(board, n, 0);
7        return count;
8    }
9
10    private void nQueens(char[][] board, int n, int row) {
11        if (row == n) {
12            count++;
13            return;
14        }
15
16        for (int col = 0; col < n; col++) {
17            if (isSafe(board, row, col, n)) {
18                board[row][col] = 'Q';
19                nQueens(board, n, row + 1);
20                board[row][col] = '\0';
21            }
22        }
23    }
24
25    private boolean isSafe(char[][] board, int row, int col, int n) {
26        for (int i = 0; i < n; i++) {
27            if (board[i][col] == 'Q') {
28                return false;
29            }
30        }
31
32        for (int j = 0; j < n; j++) {
33            if (board[row][j] == 'Q') {
34                return false;
35            }
36        }
37
38        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
39            if (board[i][j] == 'Q') {
40                return false;
41            }
42        }
43
44        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
45            if (board[i][j] == 'Q') {
46                return false;
47            }
48        }
49
50        return true;
51    }
52}