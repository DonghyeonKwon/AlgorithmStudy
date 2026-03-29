import java.io.*;
import java.util.*;

public class Main {
    static boolean[] check = new boolean[10];
    static int n, ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if(m == 0) {
            ans = 1;
            for(int i = 0; i < n; i++) {
                ans *= 10;
            }

            System.out.print(ans);
            return;
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            check[Integer.parseInt(st.nextToken())] = true;
        }

        go(0, new int[10]);
        System.out.print(ans);
    }

    static void go(int idx, int[] cnt) {
        if(idx == n) {
            for(int i = 0; i <= 9; i++) {
                if(check[i] && cnt[i] == 0) return;
            }

            ans++;
            return;
        }

        for(int i = 0; i <= 9; i++) {
            cnt[i] += 1;
            go(idx + 1, cnt);
            cnt[i] -= 1;
        }
    }
}
