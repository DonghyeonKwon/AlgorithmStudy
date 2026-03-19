import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        int l = 1;
        int r = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            r = Math.max(r, arr[i]);
        }
        m = Integer.parseInt(br.readLine());

        int ans = 0;
        while(l <= r) {
            int mid = (l + r) / 2;

            if(check(mid)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        System.out.print(ans);
    }

    static boolean check(int mid) {
        int sum = 0;
        for(int i = 0; i < n; i++) {
            if(sum > m) return false;
            sum += Math.min(mid, arr[i]);
        }

        return sum <= m;
    }
}
