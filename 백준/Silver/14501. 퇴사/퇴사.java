import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n+1];
        int[] p = new int[n+1];
        int[] dp = new int[n+2];

        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = n; i >= 1; i--) {
            int finishDay = i + t[i];

            if(finishDay > n + 1) {
                dp[i] = dp[i+1];
                continue;
            }

            dp[i] = Math.max(dp[finishDay] + p[i], dp[i+1]);

        }

        System.out.print(dp[1]);
    }
}
