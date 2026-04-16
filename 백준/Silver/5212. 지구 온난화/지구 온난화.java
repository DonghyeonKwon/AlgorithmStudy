import java.io.*;
import java.util.*;

public class Main {
    static int r, c;
    static char[][] map, newMap;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        newMap = new char[r][c];
        visited = new boolean[r][c];
        for(int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
            Arrays.fill(newMap[i], '.');
        }

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(map[i][j] == 'X' && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        int maxY = 0, minY = r, maxX = 0, minX = c;

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(newMap[i][j] == 'X') {
                    minY = Math.min(i, minY);
                    maxY = Math.max(i, maxY);

                    minX = Math.min(j, minX);
                    maxX = Math.max(j, maxX);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = minY; i <= maxY; i++) {
            for(int j = minX; j <= maxX; j++) {
                sb.append(newMap[i][j]);
            }
            sb.append('\n');
        }

        System.out.print(sb);
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

                if(ny < 0 || ny >= r || nx < 0 || nx >= c) {
                    cnt++;
                    continue;
                }
                if(map[ny][nx] == '.') {
                    cnt++;
                    continue;
                }
                if(visited[ny][nx]) continue;

                visited[ny][nx] = true;
                q.offer(new int[]{ny, nx});

            }

            if(cnt <= 2) {
                newMap[y][x] = 'X';
            }
        }
    }
}
