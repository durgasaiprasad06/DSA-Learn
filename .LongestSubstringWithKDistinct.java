/**
*  Longest Substring with At Most K Distinct Characters
* Link : https://www.naukri.com/code360/problems/distinct-characters_2221410
* Topic : Two Pointers
*/

public class Solution {

    public static int kDistinctChars(int k, String s) {

        Map<Character, Integer> map = new HashMap<>();

        int l = 0;
        int ans = 0;

        for (int r = 0; r < s.length(); r++) {

            // Add current character
            map.put(s.charAt(r),
                    map.getOrDefault(s.charAt(r), 0) + 1);

            // Remove characters until we have at most k distinct
            while (map.size() > k) {

                char ch = s.charAt(l);

                map.put(ch, map.get(ch) - 1);

                if (map.get(ch) == 0) {
                    map.remove(ch);
                }

                l++;
            }

            // Update answer
            ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}
