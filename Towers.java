/**
* Towers 
* Link : https://cses.fi/problemset/task/1073
* Topic : Greedy
*/

import java.io.*;
import java.util.*;

public class Main {

    // Find first element strictly greater than x
    static int upperBound(ArrayList<Integer> arr, int x) {
        int low = 0;
        int high = arr.size() - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr.get(mid) > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in)
        );

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> towers = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            int x = Integer.parseInt(st.nextToken());

            if (towers.isEmpty()) {
                towers.add(x);
            } else {

                int idx = upperBound(towers, x);

                if (idx == -1) {
                    towers.add(x);
                } else {
                    towers.set(idx, x);
                }
            }
        }

        System.out.println(towers.size());
    }
}
