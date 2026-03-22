import java.io.*;
import java.util.*;

public class Main {
    static int MOD = 10007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[11]; // idx = 0 : sum, idx = 1, 2, ..., 10 : 9, 8, 7, ..., 0
        Arrays.fill(dp, 1);
        if(n == 1) {
            System.out.print(10);
            return;
        }
        n--;
        while(n-->0) {
            dp[0] = 0;
            for(int i = 10; i > 0; i--) {
                if(i == 10) { // 10은 0이기에 그냥 한번 더 한다.
                    dp[0] += (dp[i] % MOD);
                } else { //나머지들은 i+1번째 값을 추가해 개수를 늘린다.
                    dp[i] += dp[i+1] % MOD;
                    dp[0] += dp[i];
                    dp[0] %= MOD;
                }
            }
        }

        System.out.print(dp[0]);
    }
}
