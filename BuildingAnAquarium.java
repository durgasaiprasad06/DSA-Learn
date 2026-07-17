/**
 * E.Building An Aquarium
 * Link : https://codeforces.com/contest/1873/problem/E
 * Topic : Binary Search on Answers
 */

import java.util.*;

public class Main {

    static boolean check(long height, int[] a, int w) {
        long waterReq = 0;

        for (int x : a) {
            if (height > x) {
                waterReq += (height - x);
            }
            if (waterReq > w) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int w = sc.nextInt();

            int[] a = new int[n];
            int max = 0;

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                max = Math.max(max, a[i]);
            }

            long low = 1;
            long high = (long) max + w;
            long ans = 0;

            while (low <= high) {
                long mid = low + (high - low) / 2;

                if (check(mid, a, w)) {
                    ans = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            System.out.println(ans);
        }

        sc.close();
    }
}
