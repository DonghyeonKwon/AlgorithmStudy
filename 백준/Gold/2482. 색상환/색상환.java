import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        if(k > n/2) {
            System.out.print(0);
            return;
        }

        if(k == 1) {
            System.out.print(n);
            return;
        }

        int mod = 1_000_000_003;

        int[][] dp = new int[n+1][k+1];
        for(int i = 0; i <= n; i++) {
            dp[i][1] = i;
            dp[i][0] = 1;
        }

        for(int i = 4; i <= n; i++) {
            for(int j = 1; j <= i/2 && j <= k; j++) {
                dp[i][j] = (dp[i-2][j-1] % mod + dp[i-1][j] % mod) % mod;
            }
        }

        System.out.print(dp[n][k]);
    }
}
