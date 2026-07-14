// Last updated: 7/14/2026, 2:23:40 PM
import java.util.*;

class Solution {

    private int rows;
    private int cols;
    private int total;

    private HashMap<Integer, Integer> map;
    private Random random;

    public Solution(int m, int n) {

        rows = m;
        cols = n;

        total = m * n;

        map = new HashMap<>();
        random = new Random();
    }

    public int[] flip() {

        int rand = random.nextInt(total);

        total--;

        int actual =
                map.getOrDefault(rand, rand);

        map.put(
            rand,
            map.getOrDefault(total, total)
        );

        return new int[]{
            actual / cols,
            actual % cols
        };
    }

    public void reset() {

        total = rows * cols;

        map.clear();
    }
}