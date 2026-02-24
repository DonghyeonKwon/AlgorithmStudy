import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[n+1][10];

        for(int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for(int i = 2; i <= n; i++) {
            for(int j = 0; j <= 9; j++) {
                    dp[i][j] = ((j == 0 ? 0 : dp[i-1][j-1]) + (j == 9 ? 0 : dp[i-1][j+1])) % 1000000000;
            }
        }

        long sum = 0;
        for(int i = 0; i <= 9; i++) {
            sum += dp[n][i];
            sum %= 1000000000;
        }

        System.out.print(sum);
    }
}
