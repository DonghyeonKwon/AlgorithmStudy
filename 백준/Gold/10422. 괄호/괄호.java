import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long[] dp = new long[5001];
        dp[0] = 1;
        dp[2] = 1;

        for(int i = 2; i < 2501; i++) {
            for(int j = 0; j < i; j++) {
                dp[i*2] += (dp[j * 2] * dp[(i-j-1)*2]);
                dp[i*2] %= 1000000007;
            }
        }

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append('\n');
        }

        System.out.print(sb);
    }
}
