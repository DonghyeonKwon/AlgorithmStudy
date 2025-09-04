import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][] arr = new int[h][w];
        int[][][] dp = new int[3][h][w];

        for(int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < w; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[0][i][j] = dp[1][i][j] = dp[2][i][j] = Integer.MAX_VALUE;
            }
        }

        for(int j = 0; j < w; j++) {
            dp[0][0][j] = arr[0][j];
            dp[1][0][j] = arr[0][j];
            dp[2][0][j] = arr[0][j];
        }

        for(int i = 1; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(j == 0) {
                    dp[0][i][j] = Math.min(dp[1][i-1][j+1], dp[2][i-1][j+1]) + arr[i][j];
                    dp[1][i][j] = dp[0][i-1][j] + arr[i][j];
                } else if(j == w - 1) {
                    dp[2][i][j] = Math.min(dp[1][i-1][j-1], dp[0][i-1][j-1]) + arr[i][j];
                    dp[1][i][j] = dp[2][i-1][j] + arr[i][j];
                } else {
                    dp[0][i][j] = Math.min(dp[1][i-1][j+1], dp[2][i-1][j+1]) + arr[i][j];
                    dp[1][i][j] = Math.min(dp[0][i-1][j], dp[2][i-1][j]) + arr[i][j];
                    dp[2][i][j] = Math.min(dp[1][i-1][j-1], dp[0][i-1][j-1]) + arr[i][j];
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < w; i++) {
            for(int j = 0; j < 3; j++) {
                answer = Math.min(answer, dp[j][h-1][i]);
            }
        }

        System.out.println(answer);
    }
}
