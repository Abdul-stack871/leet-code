// Last updated: 7/14/2026, 2:23:12 PM
class Solution {
    public int minTimeToVisitAllPoints(int[][] p) {
        int ans = 0;
        for (int i = 1; i < p.length; i++) {
            // Corrected p[i-1][0] to p[i-1][1] in the second Math.abs
            ans += Math.max(Math.abs(p[i][0] - p[i-1][0]), Math.abs(p[i][1] - p[i-1][1]));
        }
        return ans;
    }
}