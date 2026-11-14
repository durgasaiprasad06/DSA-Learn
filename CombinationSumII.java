class Solution {
    private void subSum(int idx, int[] candidates, int target, List<Integer> curr, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        for (int i = idx; i < candidates.length; i++) {
            // Skip duplicates to avoid duplicate combinations
            if (i != idx && candidates[i] == candidates[i - 1]) {
                continue;
            }
            // If the current element is less than or equal to target, explore
            if (candidates[i] <= target) {
                curr.add(candidates[i]);
                subSum(i + 1, candidates, target - candidates[i], curr, ans);
                curr.remove(curr.size() - 1); // backtrack
            } else {
                // Array is sorted, so subsequent elements will also be > target
                break; 
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        // Sorting is crucial for skipping duplicates and early termination (break)
        Arrays.sort(candidates);
        
        subSum(0, candidates, target, curr, ans);
        return ans;
    }
}
