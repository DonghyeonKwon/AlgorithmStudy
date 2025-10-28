import java.io.*;
import java.util.*;

public class Main {
    static int n, res = 0;
    static int[][] map, dp;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i = 0; i < n; i++) {
             for(int j = 0; j < n; j++) {
                 int ans = dfs(i, j);
                 if(res < ans) res = ans;
             }
        }

        System.out.print(res);
    }

    static int dfs(int y, int x) {
        if(dp[y][x] != 0) return dp[y][x];
        else {
            dp[y][x] = 1;
            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                if(map[ny][nx] > map[y][x]) {
                    dp[y][x] = Math.max(dp[y][x], dfs(ny, nx) + 1);
                }
            }

            return dp[y][x];
        }
    }
}
