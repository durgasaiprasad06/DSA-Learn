/**
* 45. Jump Game II
* Link : https://leetcode.com/problems/jump-game-ii/description/
* Greedy
*/
class Solution {
    public int jump(int[] nums) {

        int jump = 0;
        int currEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            // Find the farthest position we can reach
            farthest = Math.max(farthest, i + nums[i]);

            // We have reached the end of the current jump
            if (i == currEnd) {
                jump++;
                currEnd = farthest;
            }
        }

        return jump;
    }
}
