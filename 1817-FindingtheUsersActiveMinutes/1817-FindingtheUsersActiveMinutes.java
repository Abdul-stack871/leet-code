// Last updated: 9/1/2026, 12:09:08 PM
1class Solution {
2    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
3
4        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
5
6        for (int[] log : logs) {
7            int user = log[0];
8            int time = log[1];
9
10            if (!map.containsKey(user)) {
11                map.put(user, new HashSet<>());
12            }
13
14            map.get(user).add(time);
15        }
16
17        int[] ans = new int[k];
18
19        for (HashSet<Integer> minutes : map.values()) {
20            int uam = minutes.size();
21
22            if (uam <= k) {
23                ans[uam - 1]++;
24            }
25        }
26
27        return ans;
28    }
29}