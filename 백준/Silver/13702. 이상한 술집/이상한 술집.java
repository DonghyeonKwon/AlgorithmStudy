import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static long[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new long[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        long l = 1;
        long r = Integer.MAX_VALUE;
        long ans = 0;
        while(l <= r) {
            long mid = (l + r) / 2;

            if(check(mid)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        System.out.print(ans);
    }

    static boolean check(long mid) {
        long cnt = 0;
        for(int i = 0; i < n; i++) {
            cnt += arr[i] / mid;
        }

        return k <= cnt;
    }
}
