/**
* Maximum Meetings in One Room
* Link : https://www.geeksforgeeks.org/problems/maximum-meetings-in-one-room/1
* Topic : Greedy
*/

import java.util.*;

class Solution {

    public ArrayList<Integer> maxMeetings(int[] s, int[] f) {
        int n = s.length;

        // meetings[i] = {finishTime, index, startTime}
        int[][] meetings = new int[n][3];

        for (int i = 0; i < n; i++) {
            meetings[i][0] = f[i];
            meetings[i][1] = i;
            meetings[i][2] = s[i];
        }

        // Sort by finish time
        // If finish times are equal, sort by original index
        Arrays.sort(meetings, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int lastEnded = -1;
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int end = meetings[i][0];
            int index = meetings[i][1];
            int start = meetings[i][2];

            if (lastEnded < start) {
                ans.add(index + 1);
                lastEnded = end;
            }
        }

        // Match your C++ code
        Collections.sort(ans);

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] start = {1, 3, 0, 5, 8, 5};
        int[] finish = {2, 4, 6, 7, 9, 9};

        ArrayList<Integer> result =
                solution.maxMeetings(start, finish);

        System.out.println(result);
    }
}
