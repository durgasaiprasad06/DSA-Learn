/**
 * B.Ropes
 * Link : https://codeforces.com/edu/course/2/lesson/6/2/practice/contest/283932/problem/B
 * Topic : Binary Search on Answers (Decimal variant)
 */

import java.util.*;

public class Main {

    static boolean possible(double mid, double[] a, int n, int k) {
        long done = 0;
        for (int i = 0; i < n; i++) {
            done += (long) (a[i] / mid);
        }
        return done >= k;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        double[] a = new double[n];
        double high = 0;

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextDouble();
            high = Math.max(high, a[i]);
        }

        double low = 0;
        double ans = 0;
        double precision = 1e-7;

        while (high - low > precision) {
            double mid = low + (high - low) / 2.0;

            if (possible(mid, a, n, k)) {
                ans = mid;
                low = mid;
            } else {
                high = mid;
            }
        }

        System.out.printf("%.7f%n", ans);
        sc.close();
    }
}
