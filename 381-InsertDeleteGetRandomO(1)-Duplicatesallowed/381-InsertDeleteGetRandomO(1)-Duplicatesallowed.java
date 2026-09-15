// Last updated: 9/15/2026, 12:38:10 PM
1class RandomizedCollection {
2
3    List<Integer> nums;
4    Map<Integer, Set<Integer>> idxMap;
5    Random random;
6
7    public RandomizedCollection() {
8        nums = new ArrayList<>();
9        idxMap = new HashMap<>();
10        random = new Random();
11    }
12
13    public boolean insert(int val) {
14        boolean response = !idxMap.containsKey(val);
15
16        if (response) {
17            idxMap.put(val, new HashSet<>());
18        }
19        idxMap.get(val).add(nums.size());
20        nums.add(val);
21
22        return response;
23    }
24
25    public boolean remove(int val) {
26        if (!idxMap.containsKey(val)) {
27            return false;
28        }
29
30        Set<Integer> idxSet = idxMap.get(val);
31        int idxToBeRemoved = idxSet.iterator().next();
32        if (idxSet.size() == 1) {
33            idxMap.remove(val);
34        } else {
35            idxSet.remove(idxToBeRemoved);
36        }
37
38        int lastIdx = nums.size() - 1;
39        if (idxToBeRemoved != lastIdx) {
40            int lastVal = nums.get(lastIdx);
41            Set<Integer> lastIdxSet = idxMap.get(lastVal);
42            lastIdxSet.add(idxToBeRemoved);
43            lastIdxSet.remove(lastIdx);
44            nums.set(idxToBeRemoved, lastVal);
45        }
46
47        nums.remove(lastIdx);
48
49        return true;
50    }
51
52    public int getRandom() {
53        return nums.get(random.nextInt(nums.size()));
54    }
55}