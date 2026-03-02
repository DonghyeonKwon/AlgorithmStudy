import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[][] tmpMap;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

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

        int time = 0;
        boolean flag = false;
        int cnt = 0;
        while(!flag) {
            visited = new boolean[n][m];
            tmpMap = new int[n][m];

            cnt = 0;

            for(int i = 0; !flag && i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(map[i][j] > 0 && !visited[i][j]) {
                        if(cnt > 0) {
                            flag = true;
                            break;
                        }
                        bfs(i, j);
                        cnt++;
                    }
                }
            }

            map = tmpMap;
            if(flag || cnt == 0) break;

            time++;
        }

        System.out.print(flag ? time : 0);

    }

    static void bfs(int y, int x) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y, x});
        visited[y][x] = true;

        while(!q.isEmpty()) {
            int[] pos = q.poll();
            y = pos[0];
            x = pos[1];

            int cnt = 0;
            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if(map[ny][nx] == 0) {
                    cnt++;
                } else {
                    if(visited[ny][nx]) continue;
                    visited[ny][nx] = true;
                    q.add(new int[]{ny, nx});
                }
            }

            tmpMap[y][x] = Math.max(0, map[y][x] - cnt);
        }
    }
}
