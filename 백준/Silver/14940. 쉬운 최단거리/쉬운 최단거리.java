import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int[][] visited;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new int[n][m];

        int sy = 0, sx = 0;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    sy = i;
                    sx = j;
                }

                if(map[i][j] == 0) {
                    visited[i][j] = 0;
                } else {
                    visited[i][j] = -1;
                }
            }
        }

        bfs(sy, sx);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                bw.write(visited[i][j] + " ");
            }
            bw.write('\n');
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int y, int x) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y, x, 0});
        visited[y][x] = 0;

        while(!q.isEmpty()) {
            int[] pos = q.poll();

            for(int i = 0; i < 4; i++) {
                int ny = pos[0] + dy[i];
                int nx = pos[1] + dx[i];
                int nc = pos[2] + 1;

                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if(map[ny][nx] == 0) continue;
                if(visited[ny][nx] >= 0) continue;

                q.add(new int[]{ny, nx, nc});
                visited[ny][nx] = nc;
            }
        }
    }
}
