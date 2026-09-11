// Last updated: 9/11/2026, 12:35:42 PM
1class Solution {
2    public int totalFruit(int[] fruits) {
3        Map<Integer, Integer> basket = new HashMap<>();
4        int j=0;int i=0;
5        int res = 0;
6        for (i = 0; i < fruits.length; i++) {
7            basket.put(fruits[i], basket.getOrDefault(fruits[i], 0) + 1);
8            while(basket.size() > 2) {
9                basket.put(fruits[j], basket.get(fruits[j]) - 1);
10                basket.remove(fruits[j], 0);
11                j++;
12            }
13            res = Math.max(res, i - j + 1);
14        }
15        return res;
16    }
17}