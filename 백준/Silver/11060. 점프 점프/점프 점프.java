import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        for(int i = 1; i < n; i++) {
            if(dp[i] == Integer.MAX_VALUE) continue;
            int cnt = arr[i];

            for(int j = i + 1; j <= i + cnt && j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }

        if(dp[n] == Integer.MAX_VALUE) dp[n] = -1;
        System.out.print(dp[n]);
    }
}
