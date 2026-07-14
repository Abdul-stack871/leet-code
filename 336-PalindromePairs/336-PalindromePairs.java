// Last updated: 7/14/2026, 2:24:44 PM
import java.util.*;

class Solution {

    public List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> result = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {

            String word = words[i];

            for (int j = 0; j <= word.length(); j++) {

                String left = word.substring(0, j);
                String right = word.substring(j);

                // Case 1
                if (isPalindrome(left, 0, left.length() - 1)) {

                    String reversedRight =
                            new StringBuilder(right).reverse().toString();

                    Integer index = map.get(reversedRight);

                    if (index != null && index != i) {
                        result.add(Arrays.asList(index, i));
                    }
                }

                // Case 2
                if (right.length() > 0 &&
                    isPalindrome(right, 0, right.length() - 1)) {

                    String reversedLeft =
                            new StringBuilder(left).reverse().toString();

                    Integer index = map.get(reversedLeft);

                    if (index != null && index != i) {
                        result.add(Arrays.asList(i, index));
                    }
                }
            }
        }

        return result;
    }

    private boolean isPalindrome(String s, int left, int right) {

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}