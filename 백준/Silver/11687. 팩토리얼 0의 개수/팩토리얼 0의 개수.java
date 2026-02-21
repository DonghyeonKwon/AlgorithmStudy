import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());

        int l = 1;
        int r = m * 5;
        int ans = -1;

        while(l <= r) {
            int mid = (l + r) / 2;
            int p = check(mid);

            if(p > m) {
                r = mid - 1;
            } else if(p == m) {
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }

        System.out.print(ans);
    }

    static int check(int mid) {
        int cnt = 0;

        for(int i = 5; i <= mid; i *= 5) {
            cnt += (mid / i);
        }

        return cnt;
    }
}
