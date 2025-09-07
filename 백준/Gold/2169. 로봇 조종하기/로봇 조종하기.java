import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n+1][m+1];
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n+1][m+1];
        int[][] temp = new int[2][m+1];
        dp[1][1] = map[1][1];

        for(int i = 2; i <= m; i++) {
            dp[1][i] = dp[1][i-1] + map[1][i];
        }

        for(int i = 2; i <= n; i++) {
            temp[0][1] = dp[i-1][1] + map[i][1];

            for(int j = 2; j <= m; j++) {
                temp[0][j] = Math.max(temp[0][j-1], dp[i-1][j]) + map[i][j];
            }

            temp[1][m] = dp[i-1][m] + map[i][m];
            for(int j = m-1; j >= 1; j--) {
                temp[1][j] = Math.max(temp[1][j+1], dp[i-1][j]) + map[i][j];
            }

            for(int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(temp[0][j], temp[1][j]);
            }
        }

        System.out.print(dp[n][m]);
    }
}
