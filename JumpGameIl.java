/**
 * 45. Jump Game II
 * Link: https://leetcode.com/problems/jump-game-ii/description/
 * Approach: Greedy
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currEnd = 0;
        int farthest = 0;

        // No need to jump from the last index
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            // End of the current jump range
            if (i == currEnd) {
                jumps++;
                currEnd = farthest;
            }
        }

        return jumps;
    }
}
