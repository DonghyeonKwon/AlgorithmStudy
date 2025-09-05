import java.io.*;
import java.util.*;

public class Main {
    static int max, min;
    static int[] arr = {1, 7, 4, 2, 0, 8};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        long[] dp = new long[101];
        Arrays.fill(dp, Long.MAX_VALUE);

        dp[2] = 1;
        dp[3] = 7;
        dp[4] = 4;
        dp[5] = 2;
        dp[6] = 6;
        dp[7] = 8;
        dp[8] = 10;


        for(int i = 9; i <= 100; i++) {
            for(int j = 2; j <= 7; j++) {
                String temp = String.valueOf(dp[i-j]) + String.valueOf(arr[j-2]);
                dp[i] = Math.min(Long.parseLong(temp), dp[i]);
            }
        }

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            sb.append(dp[n]).append(" ");
            if(n%2 == 0) {
                sb.append(max(n/2)).append('\n');
            } else {
                sb.append(7).append(max((n-3)/2)).append('\n');
            }
        }

        System.out.print(sb);
    }

    static String max(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(1);
        }
        return sb.toString();
    }
}
