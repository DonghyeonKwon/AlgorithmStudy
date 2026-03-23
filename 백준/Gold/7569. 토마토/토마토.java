import java.io.*;
import java.util.*;

public class Main {
    static int n, m, h;
    static int[][][] map;
    static int[] dz = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dx = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][n][m];

        int zero = 0;
        Queue<int[]> q = new ArrayDeque<>();
        int[][][] visited = new int[h][n][m];

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < m; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    visited[i][j][k] = Integer.MAX_VALUE;
                    if(map[i][j][k] == 0) {
                        zero++;
                    }
                    else if(map[i][j][k] == 1) {
                        q.add(new int[]{i, j, k, 0});
                        visited[i][j][k] = 0;
                    }
                }
            }
        }

        if(zero == 0) {
            System.out.print(0);
            return;
        }

        int max = 0;
        while(!q.isEmpty()) {
            int[] pos = q.poll();

            max = Math.max(max, pos[3]);

            for(int i = 0; i < 6; i++) {
                int nz = pos[0] + dz[i];
                int ny = pos[1] + dy[i];
                int nx = pos[2] + dx[i];
                int ncost = pos[3] + 1;

                if(isOut(nz, ny, nx)) continue;
                if(visited[nz][ny][nx] <= ncost) continue;
                if(map[nz][ny][nx] == -1) continue;
                visited[nz][ny][nx] = ncost;
                q.add(new int[]{nz, ny, nx, ncost});
                zero--;
            }
        }

        System.out.print(zero == 0 ? max : -1);
    }

    static boolean isOut(int z, int y, int x) {
        return (z < 0 || z >= h || y < 0 || y >= n || x < 0 || x >= m);
    }
}
