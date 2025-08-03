import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        int[][] dp = new int[n][3];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 1000001;

        for(int k = 0; k < 3; k++) {
            for(int j = 0; j < 3; j++) {
                if(j == k) dp[0][j] = arr[0][j];
                else dp[0][j] = 1000001;
            }

            for(int i = 1; i < n; i++) {
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
            }

            for(int j = 0; j < 3; j++) {
                if(j != k) answer = Math.min(answer, dp[n-1][j]);
            }
        }

        System.out.print(answer);
    }
}
