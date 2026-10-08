// Last updated: 10/8/2026, 5:45:23 PM
1public class Solution {
2    public boolean searchMatrix(int[][] matrix, int target) {
3        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
4            return false;
5        }
6        int col = matrix[0].length-1;
7        int row = 0;
8        while(col >= 0 && row <= matrix.length-1) {
9            if(target == matrix[row][col]) {
10                return true;
11            } else if(target < matrix[row][col]) {
12                col--;
13            } else if(target > matrix[row][col]) {
14                row++;
15            }
16        }
17        return false;
18    }
19}