import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static long[][] dp = new long[31][31];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= 30; i++) {
            dp[i][0] = 1;
            dp[i][i] = 1;
            for(int j = 1; j < i; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }

        long res = 0;
        if(k == 0) {
            res = go(n - 1 + m - 1, n-1);
        } else {
            int kr = (k - 1) / m + 1;
            int kc = (k - 1) % m + 1;

            int p = kr - 1;
            int q = kc - 1;
            res = go(p + q, p);

            p = n - kr;
            q = m - kc;
            res *= go(p + q, p);
        }

        System.out.print(res);
    }

    static long go(int p, int q) {
        return dp[p][q];
    }
}
