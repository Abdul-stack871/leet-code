// Last updated: 7/14/2026, 2:23:50 PM
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int maxLen = 0;

        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (int key : countMap.keySet()) {
            if (countMap.containsKey(key + 1)) {
                maxLen = Math.max(maxLen, countMap.get(key) + countMap.get(key + 1));
            }
        }

        return maxLen;
    }
}