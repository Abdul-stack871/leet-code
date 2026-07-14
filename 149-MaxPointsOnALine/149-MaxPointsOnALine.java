// Last updated: 7/14/2026, 2:25:42 PM
class Solution {
    public int maxPoints(int[][] points) {
        if (points == null) return 0;
        int n = points.length;
        if (n <= 2) return n;

        int result = 0;

        for (int i = 0; i < n; i++) {
            // Map stores slope as a string "dx/dy" and the count of points on that slope
            Map<String, Integer> map = new HashMap<>();
            int duplicate = 0;
            int max = 0;

            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                // Check for duplicate points
                if (dx == 0 && dy == 0) {
                    duplicate++;
                    continue;
                }

                // Use GCD to normalize the slope
                int gcd = gcd(dx, dy);
                dx /= gcd;
                dy /= gcd;

                String key = dx + "/" + dy;
                map.put(key, map.getOrDefault(key, 0) + 1);
                max = Math.max(max, map.get(key));
            }
            // max + duplicate points + the starting point i
            result = Math.max(result, max + duplicate + 1);
        }
        return result;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}