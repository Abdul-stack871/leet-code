// Last updated: 7/14/2026, 2:23:05 PM
import java.util.*;

class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) return 0;

        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, -1);
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    dist[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int[] d : dirs) {
                int ni = curr[0] + d[0], nj = curr[1] + d[1];
                if (ni >= 0 && ni < n && nj >= 0 && nj < n && dist[ni][nj] == -1) {
                    dist[ni][nj] = dist[curr[0]][curr[1]] + 1;
                    queue.offer(new int[]{ni, nj});
                }
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        pq.offer(new int[]{dist[0][0], 0, 0});
        dist[0][0] = -1;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int sf = curr[0], r = curr[1], c = curr[2];

            if (r == n - 1 && c == n - 1) return sf;

            for (int[] d : dirs) {
                int ni = r + d[0], nj = c + d[1];
                if (ni >= 0 && ni < n && nj >= 0 && nj < n && dist[ni][nj] != -1) {
                    pq.offer(new int[]{Math.min(sf, dist[ni][nj]), ni, nj});
                    dist[ni][nj] = -1;
                }
            }
        }
        return 0;
    }
}