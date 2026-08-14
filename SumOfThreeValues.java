/**
* Sum Of Three Values
* Link : https://cses.fi/problemset/task/1641/
* Topic : Two Pointers
*/

public class Main {

    static class Pair {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());

        Pair[] a = new Pair[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(st.nextToken());
            a[i] = new Pair(value, i + 1);
        }

        // Sort by value
        Arrays.sort(a, Comparator.comparingInt(p -> p.value));

        boolean found = false;

        for (int i = 0; i < n - 2; i++) {

            int l = i + 1;
            int r = n - 1;

            while (l < r) {

                long sum = (long) a[i].value
                         + a[l].value
                         + a[r].value;

                if (sum == x) {
                    System.out.println(
                        a[i].index + " " +
                        a[l].index + " " +
                        a[r].index
                    );

                    found = true;
                    break;
                }

                if (sum < x) {
                    l++;
                } else {
                    r--;
                }
            }

            if (found)
                break;
        }

        if (!found) {
            System.out.println("IMPOSSIBLE");
        }
    }
}
