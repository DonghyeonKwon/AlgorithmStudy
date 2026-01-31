import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 10007;
    static int[][] comb = new int[53][53];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;

        for(int i = 0; i <= 52; i++) {
            comb[i][0] = 1;
        }

        for(int i = 1; i <= 52; i++) {
            for(int j = 1; j <= 52; j++) {
                comb[i][j] = (comb[i-1][j] + comb[i-1][j-1]) % MOD;
            }
        }

        for(int i = 1; i <= 13 && n - 4 * i >= 0; i++) {
            int temp = (comb[52 - 4 * i][n - 4 * i] * comb[13][i]) % MOD;

            if(i % 2 == 1) {
                ans = (ans + temp) % MOD;
            } else {
                ans = (ans - temp + MOD) % MOD;
            }
        }

        System.out.print(ans);
    }
}
