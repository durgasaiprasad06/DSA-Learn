/**
* K Sized Subarray Maximum
* Link : https://www.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1
* Topic : Sliding Window
*/

class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            // Remove elements smaller than current element
            while (!dq.isEmpty() && arr[i] > arr[dq.peekLast()]) {
                dq.pollLast();
            }

            // Add current index
            dq.offerLast(i);

            // Remove elements outside the window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Add maximum of current window
            if (i >= k - 1) {
                ans.add(arr[dq.peekFirst()]);
            }
        }

        return ans;
    }
}
