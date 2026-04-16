import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] dp;
    static int[] health;
    static int[] happy;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new int[n+1][101];
        health = new int[n+1];
        happy = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            health[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            happy[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= 99; j++) {
                if(health[i] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j - health[i]] + happy[i], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.print(dp[n][99]);
    }
}
