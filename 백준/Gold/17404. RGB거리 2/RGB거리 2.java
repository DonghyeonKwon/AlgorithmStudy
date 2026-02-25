import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][3];
        int[][] dp = new int[n][3];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 1000001;
        for(int k = 0; k < 3; k++) {
            for(int j = 0; j < 3; j++) {
                if(j == k) dp[0][j] = map[0][j];
                else dp[0][j] = 1000001;
            }

            for(int i = 1; i < n; i++) {
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + map[i][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + map[i][1];
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + map[i][2];
            }

            for(int j = 0; j < 3; j++) {
                if(k != j) answer = Math.min(answer, dp[n-1][j]);
            }
        }

        System.out.print(answer);
    }
}
