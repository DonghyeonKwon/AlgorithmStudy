import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            List<Integer> a = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                a.add(Integer.parseInt(st.nextToken()));
            }

            list.add(a);
        }

        int[][] dp = new int[n+1][h+1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= h; j++) {
                for(int block : list.get(i-1)) {
                    if(j == block) dp[i][j]++;
                    if(j > block) dp[i][j] += dp[i-1][j-block];
                }
                dp[i][j] += dp[i-1][j];
                dp[i][j] %= 10007;
            }
        }

        System.out.print(dp[n][h]);

    }
}
