/**
* Max Sum Subarray of size K
* Link : https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
* Topic : Sliding Window
*/

class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        int ans = 0;
        int currWindowSum = 0;

        for (int i = 0; i < arr.length; i++) {
            // Add current element to the window
            currWindowSum += arr[i];

            // Remove the element that goes out of the window
            if (i - k >= 0) {
                currWindowSum -= arr[i - k];
            }

            // Update the maximum sum once the window reaches size k
            if (i >= k - 1) {
                ans = Math.max(ans, currWindowSum);
            }
        }

        return ans;
    }
}
