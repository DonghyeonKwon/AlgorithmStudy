import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] dp = new int[c+101];
        int[] w = new int[n+1];
        int[] v = new int[n+1];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, 987654321);
        dp[0] = 0;

        for(int i = 1; i <= n; i++) {
            int cost = w[i];
            int people = v[i];
            for(int j = people; j < c + 101; j++) {
                dp[j] = Math.min(dp[j], cost + dp[j - people]);
            }
        }

        int result = Integer.MAX_VALUE;
        for(int i = c; i < c + 101; i++) {
            result = Math.min(result, dp[i]);
        }

        System.out.print(result);
    }
}
