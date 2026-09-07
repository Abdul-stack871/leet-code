// Last updated: 9/7/2026, 12:21:51 PM
1class Solution {
2    public int maximumSum(int[] nums) {
3     
4        int[] maxForDigitSum = new int[82];
5        int maxSum = -1;
6
7        for (int num : nums) {
8            int sum = digitSum(num);
9
10            if (maxForDigitSum[sum] > 0) {
11                maxSum = Math.max(maxSum, num + maxForDigitSum[sum]);
12            }
13
14            maxForDigitSum[sum] = Math.max(maxForDigitSum[sum], num);
15        }
16
17        return maxSum;
18    }
19
20    private int digitSum(int num) {
21        int sum = 0;
22        while (num > 0) {
23            sum += num % 10;
24            num /= 10;
25        }
26        return sum;
27    }
28}