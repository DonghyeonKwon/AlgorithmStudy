import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = 0;
        int[] dp = new int[n+1];
        for(int i = 1; i <= n; i++) {
            int p = Integer.parseInt(st.nextToken());
            dp[p] = dp[p-1] + 1;
            max = Math.max(max, dp[p]);
        }
        
        System.out.print(n - max);
    }
}
