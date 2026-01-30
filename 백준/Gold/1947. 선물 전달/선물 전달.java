import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[1_000_001];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 2;

        for(int i = 4; i <= 1_000_000; i++) {
            dp[i] = (dp[i-2] + dp[i-1]) * (i - 1) % 1_000_000_000;
        }

        System.out.print(dp[n]);
    }
}
