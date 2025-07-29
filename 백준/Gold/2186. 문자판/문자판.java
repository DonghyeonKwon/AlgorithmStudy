import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k, len;

    static char[][] map;
    static int[][][] dp;
    static String input;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < m; j++) { 
                map[i][j] = str.charAt(j);
            }
        }

        input = br.readLine();
        len = input.length();
        dp = new int [n][m][len];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        int ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == input.charAt(0)) {
                    ans += dfs(i, j, 0);
                }
            }
        }

        System.out.println(ans);
    }

    static int dfs(int y, int x, int l) {
        if(dp[y][x][l] != -1) return dp[y][x][l];

        if(l == len - 1) {
            return dp[y][x][l] = 1;
        }

        dp[y][x][l] = 0;

        for(int i = 0; i < 4; i++) {
            for(int p = 1; p <= k; p++) {
                int ny = y + dy[i] * p;
                int nx = x + dx[i] * p;

                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if(map[ny][nx] != input.charAt(l+1)) continue;

                dp[y][x][l] += dfs(ny, nx, l + 1);
            }
        }

        return dp[y][x][l];
    }
}
