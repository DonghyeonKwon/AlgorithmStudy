import java.io.*;
import java.util.*;

public class Main {
    static int n, m;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> ice = new ArrayDeque<>();
    static Queue<int[]> melted = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > 0) ice.offer(new int[]{i, j});
            }
        }

        int time = 0;
        while(true) {
            while(!ice.isEmpty()){
                int[] pos = ice.poll();

                for(int d = 0; d < 4; d++) {
                    int ny = pos[0] + dy[d];
                    int nx = pos[1] + dx[d];

                    if(map[ny][nx] == 0) melted.offer(new int[]{pos[0], pos[1]});
                }
            }

            while (!melted.isEmpty()) {
                int[] pos = melted.poll();
                int y = pos[0];
                int x = pos[1];

                if(map[y][x] == 0) continue;

                map[y][x]--;
            }

            time++;

            visited = new boolean[n][m];
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] == 0) continue;
                    if (visited[i][j]) continue;

                    count_bfs(i, j);
                    cnt++;
                }
            }

            if(cnt > 1) break;

            if(cnt == 0) {
                time = 0;
                break;
            }
        }

        bw.write(Integer.toString(time));
        bw.flush();

        bw.close();
        br.close();
    }

    static void count_bfs(int y, int x){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y, x});
        visited[y][x] = true;

        while(!q.isEmpty()) {
            int[] pos = q.poll();
            y = pos[0];
            x = pos[1];

            ice.offer(new int[]{y, x});

            for(int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if(visited[ny][nx]) continue;
                if(map[ny][nx] == 0) continue;

                q.offer(new int[]{ny,nx});
                visited[ny][nx] = true;
            }
        }
    }
}
