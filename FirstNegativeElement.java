/**
* First negative in every window of size k
* Link : https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
* Topic : Sliding Window
*/

class Solution {
    public List<Integer> firstNegInt(int[] arr, int k) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            // Add negative element's index to the queue
            if (arr[i] < 0) {
                q.offer(i);
            }

            // Remove indices that are out of the current window
            if (!q.isEmpty() && q.peek() <= i - k) {
                q.poll();
            }

            // Store the first negative element for each valid window
            if (i >= k - 1) {
                if (q.isEmpty()) {
                    ans.add(0);
                } else {
                    ans.add(arr[q.peek()]);
                }
            }
        }

        return ans;
    }
}
