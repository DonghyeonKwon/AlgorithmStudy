import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static long[][] dp;
    static int[] dy = {0, 1};
    static int[] dx = {1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new long[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        long ans = dfs(0, 0);

        System.out.print(ans);
    }

    static long dfs(int y, int x) {
        int value = map[y][x];
        if(y == n-1 && x == n-1) {
            return 1;
        }

        if(dp[y][x] != -1) {
            return dp[y][x];
        }

        dp[y][x] = 0;
        if(value == 0) return dp[y][x];
        for(int i = 0; i < 2; i++) {
            int ny = y + dy[i] * value;
            int nx = x + dx[i] * value;

            if(ny >= n || nx >= n) continue;
            dp[y][x] += dfs(ny, nx);
        }

        return dp[y][x];
    }
}
