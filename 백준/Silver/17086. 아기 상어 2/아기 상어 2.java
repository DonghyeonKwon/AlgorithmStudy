import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int[] dy = {-1, 0, 1, 0, -1, -1, 1, 1};
    static int[] dx = {0, -1, 0, 1, 1, -1, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0) {
                    max = Math.max(bfs(i, j), max);
                }
            }
        }

        System.out.print(max);
    }

    static int bfs(int y, int x) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y, x});
        int[][] visited = new int[n][m];
        for(int i = 0; i < n; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        visited[y][x] = 0;
        int min = 10000000;

        while(!q.isEmpty()) {
            int[] pos = q.poll();

            y = pos[0];
            x = pos[1];

            if(map[y][x] == 1) {
                min = Math.min(min, visited[y][x]);
                continue;
            }

            for(int i = 0; i < 8; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if(visited[ny][nx] <= visited[y][x] + 1) continue;

                visited[ny][nx] = visited[y][x] + 1;
                q.add(new int[]{ny,nx});
            }
        }

        return min;
    }
}
