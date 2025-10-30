import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n - 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int total = Integer.parseInt(st.nextToken());
        long answer = 0;

        long[][] dp = new long[n + 1][21];
        dp[1][arr[1]] = 1;

        for(int i = 1; i <= n - 2; i++) {
            for(int j = 0; j <= 20 ; j++) {
                if(dp[i][j] != 0) {
                    int plus = j + arr[i + 1];
                    int minus = j - arr[i + 1];

                    if(plus >= 0 && plus <= 20) {
                        dp[i+1][plus] += dp[i][j];
                    }

                    if(minus >= 0 && minus <= 20) {
                        dp[i+1][minus] += dp[i][j];
                    }
                }
            }
        }

        answer = dp[n-1][total];
        System.out.print(answer);
    }
}
