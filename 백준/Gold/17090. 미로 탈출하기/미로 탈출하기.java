import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] dp;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dp = new boolean[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            String input = br.readLine();

            for(int j = 0; j < m; j++) {
                char c = input.charAt(j);
                if(c == 'U') {
                    map[i][j] = 0;
                } else if(c == 'L') {
                    map[i][j] = 1;
                } else if(c == 'D') {
                    map[i][j] = 2;
                } else if(c == 'R') {
                    map[i][j] = 3;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j]) {
                    dp[i][j] = dfs(i, j);
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(dp[i][j]) cnt++;
            }
        }

        System.out.print(cnt);
    }

    static boolean dfs(int y, int x) {
        if(y < 0 || y >= n || x < 0 || x >= m) return true;
        if(visited[y][x]) return dp[y][x];
        visited[y][x] = true;
        return dp[y][x] = dfs(y + dy[map[y][x]], x + dx[map[y][x]]);
    }
}
