/**
* Minimum Platforms
* Link : https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1
* Topic : Greedy
*/

import java.util.*;

class Solution {

    public int minPlatform(int[] arr, int[] dep) {
        int n = arr.length;

        // Store arrival and departure times together
        int[][] trains = new int[n][2];

        for (int i = 0; i < n; i++) {
            trains[i][0] = arr[i];
            trains[i][1] = dep[i];
        }

        // Sort trains according to arrival time
        Arrays.sort(trains, (a, b) -> Integer.compare(a[0], b[0]));

        // Min-heap to store departure times
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int ans = 0;

        for (int i = 0; i < n; i++) {

            // Remove a train if its platform is free
            if (!pq.isEmpty() && pq.peek() < trains[i][0]) {
                pq.poll();
            }

            // Add current train's departure time
            pq.offer(trains[i][1]);

            // Maximum platforms required
            ans = Math.max(ans, pq.size());
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};

        int result = solution.minPlatform(arr, dep);

        System.out.println("Minimum platforms required: " + result);
    }
}
