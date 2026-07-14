// Last updated: 7/14/2026, 2:27:01 PM
class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        findCombination(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    public void findCombination(int[] candidates, int target, int index,
                                List<Integer> current, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            current.add(candidates[i]);

            findCombination(candidates, target - candidates[i], i, current, result);

            current.remove(current.size() - 1);
        }
    }
}