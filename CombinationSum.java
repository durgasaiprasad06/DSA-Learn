/**
* 39. Combination Sum
* Link : https://leetcode.com/problems/combination-sum/description/
* Topic : Recursion
*/
class Solution {
    private void solve(int index, int currSum, int target, List<Integer> curr, List<List<Integer>> ans, int[] candidates) {
        // base case
        if (currSum == target) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if (index == candidates.length) {
            return;
        }
        
        // option 1 
        if (currSum + candidates[index] <= target) {
            curr.add(candidates[index]);
            solve(index, currSum + candidates[index], target, curr, ans, candidates);
            curr.remove(curr.size() - 1); // backtrack
        }
        
        // option 2 
        solve(index + 1, currSum, target, curr, ans, candidates);
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, 0, target, curr, ans, candidates);
        return ans;
    }
}
