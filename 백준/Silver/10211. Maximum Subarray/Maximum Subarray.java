import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while(t-->0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            int[] dp = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int max = arr[0];
            dp[0] = arr[0];
            for(int i = 1; i < n; i++) {
                if(dp[i-1] < 0) dp[i-1] = 0;
                dp[i] = dp[i-1] + arr[i];
                max = Math.max(max, dp[i]);
            }

            sb.append(max).append('\n');
        }

        System.out.print(sb);
    }
}
