// Last updated: 8/22/2026, 10:08:42 AM
1
2 class Solution {
3    public List<List<Integer>> permuteUnique(int[] nums) {
4        Arrays.sort(nums);
5        return solve(nums, nums.length);
6    }
7
8    private List<List<Integer>> solve(int[] nums, int n) {
9        if (n == 1) {
10            List<List<Integer>> base = new ArrayList<>();
11            List<Integer> list = new ArrayList<>();
12
13            list.add(nums[0]);
14            base.add(list);
15
16            return base;
17        }
18
19        List<List<Integer>> previous = solve(nums, n - 1);
20        Set<List<Integer>> res = new LinkedHashSet<>();
21
22        int value = nums[n - 1];
23
24        for (List<Integer> permutation : previous) {
25            for (int i = 0; i <= permutation.size(); i++) {
26                List<Integer> current = new ArrayList<>();
27
28                for (int j = 0; j < i; j++) {
29                    current.add(permutation.get(j));
30                }
31
32                current.add(value);
33
34                for (int j = i; j < permutation.size(); j++) {
35                    current.add(permutation.get(j));
36                }
37
38                res.add(current);
39            }
40        }
41
42        return new ArrayList<>(res);
43    }
44}