import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] dy = {-2, -2, 0, 0, 2, 2};
    static int[] dx = {-1, 1, -2, 2, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());

        System.out.print(bfs(r1, c1, r2, c2));
    }

    static int bfs(int r1, int c1, int r2, int c2) {
        Queue<int[]> q = new ArrayDeque<>();
        int[][] visited = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }

        q.add(new int[] {r1, c1});
        visited[r1][c1] = 0;

        while(!q.isEmpty()) {
            int[] pos = q.poll();

            int y = pos[0];
            int x = pos[1];

            if(y == r2 && x == c2) {
                return visited[y][x];
            }

            for(int i = 0; i < 6; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                if(visited[ny][nx] <= visited[y][x] + 1) continue;
                visited[ny][nx] = visited[y][x] + 1;
                q.add(new int[]{ny, nx});
            }
        }

        return -1;
    }
}
