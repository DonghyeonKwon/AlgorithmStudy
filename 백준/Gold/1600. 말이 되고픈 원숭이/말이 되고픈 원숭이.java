import java.io.*;
import java.util.*;

public class Main {
    static int MIN = 999_999_999;
    static int k, w, h;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dy = {-1, 0, 1, 0}, ddy = {-2, -1, -2, -1, 2, 1, 2, 1};
    static int[] dx = {0, -1, 0, 1}, ddx = {-1, -2, 1, 2, -1, -2, 1, 2};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][w];
        visited = new boolean[h][w][k+1];

        for(int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < w; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(0, 0, k);

        bw.write(Integer.toString(MIN == 999_999_999 ? -1 : MIN));
        bw.flush();

        bw.close();
        br.close();
    }

    static void bfs(int y, int x, int k) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y, x, 0, k});
        visited[y][x][k] = true;

        while(!q.isEmpty()) {
            int[] point = q.poll();

            if(point[0] == h-1 && point[1] == w-1){
                MIN = Math.min(MIN, point[2]);
                continue;
            }

            for(int i = 0; i < 4; i++){
                int ny = point[0] + dy[i];
                int nx = point[1] + dx[i];

                if(ny < 0 || ny >= h || nx < 0 || nx >= w) continue;
                if(map[ny][nx] == 1) continue;
                if(visited[ny][nx][point[3]]) continue;

                q.offer(new int[]{ny, nx, point[2]+1, point[3]});
                visited[ny][nx][point[3]] = true;
            }


            if(point[3] > 0) {
                for(int i = 0; i < 8; i++) {
                    int ny = point[0] + ddy[i];
                    int nx = point[1] + ddx[i];

                    if(ny < 0 || ny >= h || nx < 0 || nx >= w) continue;
                    if(map[ny][nx] == 1) continue;
                    if(visited[ny][nx][point[3]-1]) continue;

                    q.offer(new int[]{ny, nx, point[2]+1, point[3]-1});
                    visited[ny][nx][point[3]-1] = true;
                }
            }

        }
    }
}
