import java.io.*;
import java.util.*;

public class Main {
    static int[] dp;
    static int n, k;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new int[n+1];

        dp[n] = k;
        for(int i = 1; i < dp[n]; i++) {
            if(dp[n] - i >= i) continue;
            dp[n - 1] = i;
            dp[n - 2] = dp[n] - i;
            if(go(n - 1)) break;
        }

        System.out.print(dp[1] + "\n" + dp[2]);
    }

    static boolean go(int day) {
        if(day == 2) {
            if(dp[day] > dp[day+1]) return false;
            return true;
        }

        if(dp[day] - dp[day - 1] >= dp[day - 1]) return false;
        dp[day - 2] = dp[day] - dp[day - 1];
        return go(day - 1);
    }
}
