// Last updated: 7/14/2026, 2:25:45 PM
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        Set<String> dict = new HashSet<>(wordDict);
        return backtrack(s, dict, 0, dp);
    }

    private boolean backtrack(String s, Set<String> dict, int start, Boolean[] dp) {
        if (start == s.length()) {
            return true;
        }

        if (dp[start] != null) {
            return dp[start];
        }

        for (int end = start; end < s.length(); end++) {
            String subString = s.substring(start, end + 1);

            if (dict.contains(subString)) {
                if (backtrack(s, dict, end + 1, dp)) {
                    dp[start] = true;
                    return true;
                }
            }
        }

        dp[start] = false;
        return false;
    }
}