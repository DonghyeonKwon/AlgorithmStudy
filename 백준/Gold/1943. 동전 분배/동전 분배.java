import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = 3;
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] v = new int[n+1];
            int[] c = new int[n+1];
            int sum = 0;
            for(int i = 1; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                v[i] = Integer.parseInt(st.nextToken());
                c[i] = Integer.parseInt(st.nextToken());
                sum += (v[i] * c[i]);
            }

            if(sum % 2 == 1) {
                sb.append("0\n");
                continue;
            }

            sum /= 2;
            boolean[][] dp = new boolean[n+1][sum+1];
            dp[0][0] = true;
            for(int i = 1; i <= n; i++) {
                for(int j = 0; j <= sum; j++) {
                    if(dp[i-1][j]) {
                        for(int k = 0; k <= c[i]; k++) {
                            int tmp = j + v[i] * k;
                            if(tmp <= sum) {
                                dp[i][tmp] = true;
                            }
                        }
                    }
                }
            }

            if(dp[n][sum]) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }

        }

        System.out.print(sb);
    }
}
