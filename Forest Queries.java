import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        String[] grid = new String[n];

        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine();
        }

        int[][] prefix = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] =
                        (grid[i - 1].charAt(j - 1) == '*' ? 1 : 0)
                        + prefix[i - 1][j]
                        + prefix[i][j - 1]
                        - prefix[i - 1][j - 1];
            }
        }

        StringBuilder sb = new StringBuilder();

        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());

            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            int ans =
                    prefix[y2][x2]
                    - prefix[y1 - 1][x2]
                    - prefix[y2][x1 - 1]
                    + prefix[y1 - 1][x1 - 1];

            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }
}
