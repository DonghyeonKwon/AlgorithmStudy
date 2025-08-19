import java.io.*;
import java.util.*;

public class Main {
    static int n, m, max = 0;
    static int[][] map;
    static boolean[][] visited;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(n <= 1 || m <= 1) {
            System.out.print(0);
            return;
        }

        go(0,0);

        System.out.print(max);
    }

    static void go(int cnt, int sum) {
        int i = cnt / m;
        int j = cnt % m;

        if(cnt == n * m) {
            max = Math.max(max, sum);
            return;
        }

        if(!visited[i][j]) {
            visited[i][j] = true;

            for(int d = 0; d < 4; d++) {
                int dd = (d + 1) % 4;

                int ny = i + dy[d];
                int nx = j + dx[d];
                if(ny < 0 || ny >= n || nx < 0|| nx >= m) continue;
                if(visited[ny][nx]) continue;

                int nyy = i + dy[dd];
                int nxx = j + dx[dd];
                if(nyy < 0 || nyy >= n || nxx < 0 || nxx >= m) continue;
                if(visited[nyy][nxx]) continue;

                visited[ny][nx] = true;
                visited[nyy][nxx] = true;
                go(cnt +1, sum + (map[i][j] * 2) + map[ny][nx] + map[nyy][nxx]);
                visited[ny][nx] = false;
                visited[nyy][nxx] = false;
            }

            visited[i][j] = false;
        }

        go(cnt+1, sum);
    }
}
