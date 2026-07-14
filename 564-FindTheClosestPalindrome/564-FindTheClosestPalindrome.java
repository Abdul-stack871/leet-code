// Last updated: 7/14/2026, 2:23:55 PM
class Solution {

    public String nearestPalindromic(String n) {

        long num = Long.parseLong(n);
        int len = n.length();

        HashSet<Long> candidates = new HashSet<>();

        candidates.add((long)Math.pow(10, len) + 1);
        candidates.add((long)Math.pow(10, len - 1) - 1);

        long prefix =
            Long.parseLong(
                n.substring(0, (len + 1) / 2)
            );

        for(long i = prefix - 1; i <= prefix + 1; i++) {

            String firstHalf = String.valueOf(i);

            StringBuilder sb =
                new StringBuilder(firstHalf);

            if(len % 2 == 1) {
                sb.deleteCharAt(sb.length() - 1);
            }

            String palindrome =
                firstHalf +
                sb.reverse().toString();

            candidates.add(
                Long.parseLong(palindrome)
            );
        }

        candidates.remove(num);

        long answer = -1;

        for(long candidate : candidates) {

            if(answer == -1) {
                answer = candidate;
                continue;
            }

            long diff1 =
                Math.abs(candidate - num);

            long diff2 =
                Math.abs(answer - num);

            if(diff1 < diff2) {
                answer = candidate;
            }
            else if(diff1 == diff2 &&
                    candidate < answer) {
                answer = candidate;
            }
        }

        return String.valueOf(answer);
    }
}