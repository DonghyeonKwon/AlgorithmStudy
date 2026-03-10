import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] visited;
    static int[] dy = {-2, -2, 0, 0, 2, 2};
    static int[] dx = {-1, 1, -2, 2, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        visited = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int sy = Integer.parseInt(st.nextToken());
        int sx = Integer.parseInt(st.nextToken());
        int ey = Integer.parseInt(st.nextToken());
        int ex = Integer.parseInt(st.nextToken());

        bfs(sy, sx, ey, ex);

        System.out.print(visited[ey][ex] == Integer.MAX_VALUE ? -1 : visited[ey][ex]);
    }

    static void bfs(int sy, int sx, int ey, int ex) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sy, sx});
        visited[sy][sx] = 0;

        while(!q.isEmpty()) {
            int[] pos = q.poll();
            int y = pos[0];
            int x = pos[1];

            if(ey == y && ex == x) break;

            for(int d = 0; d < 6; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if(ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                if(visited[ny][nx] <= visited[y][x] + 1) continue;
                visited[ny][nx] = visited[y][x] + 1;
                q.add(new int[]{ny, nx});
            }
        }
    }
}
