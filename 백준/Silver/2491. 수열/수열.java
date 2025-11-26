import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[2][n];
        int ans = 1;
        dp[0][0] = dp[1][0] = 1;
        for(int i = 1; i < n; i++) {
            if(arr[i] >= arr[i-1]) {
                dp[0][i] = dp[0][i-1] + 1;
            } else {
                dp[0][i] = 1;
            }

            if(arr[i] <= arr[i-1]) {
                dp[1][i] = dp[1][i-1] + 1;
            } else {
                dp[1][i] = 1;
            }

            ans = Math.max(ans, Math.max(dp[0][i], dp[1][i]));
        }

        System.out.print(ans);
    }
}
