import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[101];
        for(int i = 1; i <= n; i++) {
            dp[i] = dp[i-1] + 1;

            if(i > 6) {
                for(int j = 2; j < 5; j++) {
                    dp[i] = Math.max(dp[i], dp[i-(j+1)] * j);
                }
            }
        }


        System.out.print(dp[n]);
    }
}
