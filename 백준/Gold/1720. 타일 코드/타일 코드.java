import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        if(n < 2) {
            System.out.println(dp[n]);
            return;
        }

        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2] * 2;
        }

        if(n % 2 == 1) {
            dp[n] = (dp[n] + dp[n/2]) / 2;
        } else {
            dp[n] = (dp[n/2 - 1] * 2 + dp[n/2] + dp[n]) / 2;
        }

        System.out.println(dp[n]);
    }
}
