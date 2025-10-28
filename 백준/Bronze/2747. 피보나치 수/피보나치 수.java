import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dp = new int[46];

        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= 45; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        int n = Integer.parseInt(br.readLine());
        System.out.print(dp[n]);
    }
}
