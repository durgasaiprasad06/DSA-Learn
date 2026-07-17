/**
* 875. Koko eating Bananas
* Link : https://leetcode.com/problems/koko-eating-bananas/description/
* Topic : Binary Search on Answers
*/

class Solution {

    private boolean check(int speed, int[] piles, int h) {
        long hoursRequired = 0;

        for (int bananas : piles) {
            hoursRequired += (bananas + speed - 1L) / speed;
        }

        return hoursRequired <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        for (int bananas : piles) {
            high = Math.max(high, bananas);
        }

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (check(mid, piles, h)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
