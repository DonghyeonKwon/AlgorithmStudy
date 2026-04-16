import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= 40; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int idx = 0;
        int ans = 1;
        for(int i = 0; i < m; i++) {
            int p = Integer.parseInt(br.readLine());
            ans *= dp[p - idx - 1];
            idx = p;
        }

        if(idx < n) {
            ans *= dp[n - idx];
        }

        System.out.print(ans);

    }
}
