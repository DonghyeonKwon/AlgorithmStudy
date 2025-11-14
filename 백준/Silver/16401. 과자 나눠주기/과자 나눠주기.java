import java.io.*;
import java.util.*;

public class Main {
    static int m, n;
    static int[] snack;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        snack = new int[n];
        int max = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            snack[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, snack[i]);
        }

        Arrays.sort(snack);

        int left = 1;
        int right = max;
        int ans = 0;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(check(mid)) {
                left = mid + 1;
                ans = Math.max(ans, mid);
            } else {
                right = mid - 1;
            }
        }
        System.out.print(ans);
    }

    static boolean check(int mid) {
        int cnt = 0;

        for(int i = n-1; i >= 0; i--) {
            if(snack[i] < mid) break;
            cnt += snack[i] / mid;
        }

        return m <= cnt;
    }
}
