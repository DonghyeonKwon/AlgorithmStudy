import java.io.*;
import java.util.*;

public class Main {
    static int n, m, max = -1, zeroCnt = 0;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static int[][] map;
    static boolean[][] visited;
    static List<int[]> virus = new ArrayList<>();
    static List<int[]> zero = new ArrayList<>();

    public static void main(String args[]) throws Exception {
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
                if(map[i][j] == 2) {
                    virus.add(new int[]{i, j});
                } else if(map[i][j] == 0) {
                    zeroCnt++;
                    zero.add(new int[]{i, j});
                }
            }
        }

        buildWall(0,0);

        bw.write(Integer.toString(max));
        bw.flush();

        bw.close();
        br.close();
    }

    static void buildWall(int idx, int cnt) {
        if(cnt == 3) {
            bfs();
            return;
        }

        for(int i = idx; i < zero.size(); i++) {
            int[] pos = zero.get(i);
            map[pos[0]][pos[1]] = 1;
            buildWall(i+1, cnt+1);
            map[pos[0]][pos[1]] = 0;
        }
    }

    static void bfs() {
        Queue<int[]> q = new ArrayDeque<>(virus);
        visited = new boolean[n][m];

        int changeCnt = 0;

        while(!q.isEmpty()) {
            int[] pos = q.poll();
            int y = pos[0];
            int x = pos[1];

            visited[y][x] = true;

            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if(visited[ny][nx]) continue;
                if(map[ny][nx] != 0) continue;

                changeCnt++;
                visited[ny][nx] = true;
                q.offer(new int[]{ny, nx});
            }
        }

        int res = zeroCnt - changeCnt - 3;
        max = Math.max(max, res);
    }
}
