/**
* 56. Merge Intervals
* Link : https://leetcode.com/problems/merge-intervals/description/
* Topic : Greedy
*/

import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        List<int[]> ans = new ArrayList<>();

        // Sort by starting time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < intervals.length; i++) {

            int s = intervals[i][0];
            int e = intervals[i][1];

            // No overlap
            if (ans.isEmpty() || ans.get(ans.size() - 1)[1] < s) {
                ans.add(new int[]{s, e});
            }

            // Overlap
            else {
                int[] last = ans.get(ans.size() - 1);
                last[1] = Math.max(e, last[1]);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
