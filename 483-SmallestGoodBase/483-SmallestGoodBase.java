// Last updated: 7/14/2026, 2:24:05 PM
class Solution {

    public String smallestGoodBase(String n) {

        long num = Long.parseLong(n);

        int maxLen =
                (int)(Math.log(num) / Math.log(2));

        for(int m = maxLen; m >= 2; m--) {

            long k =
                (long)Math.pow(num, 1.0 / m);

            if(k < 2) continue;

            long sum = 1;
            long curr = 1;

            for(int i = 1; i <= m; i++) {

                curr *= k;
                sum += curr;

                if(sum > num)
                    break;
            }

            if(sum == num)
                return String.valueOf(k);
        }

        return String.valueOf(num - 1);
    }
}