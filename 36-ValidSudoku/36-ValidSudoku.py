# Last updated: 8/10/2026, 12:03:25 PM
1class Solution:
2    def isValidSudoku(self, board: List[List[str]]) -> bool:
3        rows = defaultdict(set)
4        cols = defaultdict(set)
5        boxes = defaultdict(set)
6        
7        for r in range(9):
8            for c in range(9):
9                if board[r][c] == ".":
10                    continue
11                
12                if board[r][c] in rows[r] or board[r][c] in cols[c] or board[r][c] in boxes[(r // 3, c // 3)]:
13                    return False
14                
15                rows[r].add(board[r][c])
16                cols[c].add(board[r][c])
17                boxes[(r // 3, c // 3)].add(board[r][c])
18        
19        return True