import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 987654321;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] dp = new long[10001];
        dp[0] = 1;
        dp[2] = 1;

        for(int i = 4; i <= 10000; i += 2) {
            for(int j = 0; j <= i - 2; j += 2) {
                dp[i] += dp[j] * dp[i - j - 2];
                dp[i] %= MOD;
            }
        }

        int n = Integer.parseInt(br.readLine());
        System.out.println(dp[n]);
    }
}
