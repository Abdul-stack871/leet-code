// Last updated: 8/7/2026, 10:06:51 AM
1import java.util.Arrays;
2
3class Solution {
4    int primes[] = new int[]{2, 3, 5, 7};
5    int maxPrime = primes[primes.length - 1];
6
7    public String smallestNumber(String num, long t) {
8        int primeCount[] = new int[maxPrime + 1];
9        int numLength = num.length();
10        int minLength;
11        int firstZeroIndexFromLeft = 0;
12
13        for (int prime : primes) {
14            while (t % prime == 0) {
15                t /= prime;
16                primeCount[prime]++;
17            }
18        }
19        
20        if (t != 1) { 
21            return "-1"; 
22        }
23
24        minLength = getMinLength(primeCount);
25        
26        if (numLength < minLength) {
27            return buildSuffix(primeCount, minLength, new char[minLength]);
28        }
29
30        char[] result = new char[numLength + 1];
31        
32        for (int i = 0; firstZeroIndexFromLeft < numLength && (result[++i] = num.charAt(firstZeroIndexFromLeft)) != '0'; firstZeroIndexFromLeft++) {
33            logNum(primeCount, result[i], -1);
34        }
35
36        if (getMinLength(primeCount) == 0) {
37            if (firstZeroIndexFromLeft == numLength) { 
38                return num; 
39            }
40            Arrays.fill(result, ++firstZeroIndexFromLeft, result.length, '1');
41            return new String(result, 1, numLength);
42        }
43
44        for (int last = numLength - 1, end = Math.min(firstZeroIndexFromLeft, last); end >= 0; end--) {
45            for (logNum(primeCount, result[end + 1], 1); ++result[end + 1] <= '9'; logNum(primeCount, result[end + 1], 1)) {
46                logNum(primeCount, result[end + 1], -1);
47                if (getMinLength(primeCount) <= last - end) {
48                    return buildSuffix(primeCount, last - end, result);
49                }
50            }
51        }
52        
53        return buildSuffix(primeCount, result.length, result);
54    }
55
56    void logNum(int[] primeCount, int num, int value) {
57        if (num < '2') return;
58        if (num == '9') primeCount[3] += value << 1;
59        else if (num == '4') primeCount[2] += value << 1;
60        else if (num == '8') primeCount[2] += value * 3;
61        else if (num == '6') {
62            primeCount[2] += value;
63            primeCount[3] += value;
64        } else {
65            primeCount[num - '0'] += value;
66        }
67    }
68
69    String buildSuffix(int[] primeCount, int targetLength, char[] result) {
70        int index = result.length;
71        while (primeCount[3] > 1) { primeCount[3] -= 2; result[--index] = '9'; }
72        while (primeCount[2] > 2) { primeCount[2] -= 3; result[--index] = '8'; }
73        while (primeCount[7]-- > 0) result[--index] = '7';
74        if (primeCount[2] > 0 && primeCount[3] > 0) { result[--index] = '6'; primeCount[2]--; primeCount[3]--; }
75        while (primeCount[5]-- > 0) result[--index] = '5';
76        while (primeCount[2] > 1) { primeCount[2] -= 2; result[--index] = '4'; }
77        while (primeCount[3] > 0) { primeCount[3]--; result[--index] = '3'; }
78        while (primeCount[2] > 0) { primeCount[2]--; result[--index] = '2'; }
79        while (index + targetLength != result.length) { result[--index] = '1'; }
80        
81        return targetLength == result.length ? new String(result) : new String(result, 1, result.length - 1);
82    }
83
84    int getMinLength(int[] primeCount) {
85        int count2 = Math.max(0, primeCount[2]);
86        int count3 = Math.max(0, primeCount[3]);
87        int count23 = (count3 & 1) + (count2 % 3);
88        
89        return (count3 >> 1) + (count2 / 3) + Math.max(0, primeCount[7]) + Math.max(0, primeCount[5]) + (count23 == 3 ? 2 : count23 > 0 ? 1 : 0);
90    }
91}