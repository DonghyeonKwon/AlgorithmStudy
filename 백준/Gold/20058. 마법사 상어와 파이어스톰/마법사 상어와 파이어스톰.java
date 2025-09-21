import java.io.*;
import java.util.*;

public class Main {

    static int len;
    static int[][] map, temp;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        len = (int) Math.pow(2, n);
        map = new int[len][len];
        for(int i = 0; i < len; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < len; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < q; i++) {
            temp = new int[len][len];
            int l = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
            go(0, 0, len, l);

            for(int y = 0; y < len; y++) {
                for(int x = 0; x < len; x++) {

                    if(temp[y][x] == 0) {
                        map[y][x] = temp[y][x];
                        continue;
                    }

                    int cnt = 0;
                    for(int d = 0; d < 4; d++) {
                        int ny = y + dy[d];
                        int nx = x + dx[d];

                        if(ny < 0 || ny >= len || nx < 0 || nx >= len) continue;
                        if(temp[ny][nx] == 0) continue;
                        cnt++;
                    }

                    if(cnt < 3) {
                        map[y][x] = temp[y][x] - 1;
                    } else {
                        map[y][x] = temp[y][x];
                    }
                }
            }
        }

        int sum = 0;
        int cnt = 0;
        visited = new boolean[len][len];
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                sum += map[i][j];

                if(map[i][j] > 0 && !visited[i][j]) {
                    cnt = Math.max(cnt, bfs(i, j));
                }
            }
        }

        System.out.print(sum + "\n" + cnt);
    }

    static int bfs(int y, int x) {
        Queue<int[]> q = new ArrayDeque<>();
        int cnt = 1;
        visited[y][x] = true;
        q.add(new int[]{y, x});

        while (!q.isEmpty()) {
            int[] pos = q.poll();

            for(int i = 0; i < 4; i++) {
                int ny = pos[0] + dy[i];
                int nx = pos[1] + dx[i];

                if(ny < 0 || ny >= len || nx < 0 || nx >= len) continue;
                if(map[ny][nx] == 0) continue;
                if(visited[ny][nx]) continue;

                visited[ny][nx] = true;
                q.add(new int[]{ny, nx});
                cnt++;
            }
        }

        return cnt;
    }

    static void go(int y, int x, int len, int l) {
        if(len == l) {
            for(int i = 0; i < len; i++) {
                for(int j = 0; j < len; j++) {
                    temp[y + j][x + len - i - 1] = map[y + i][x + j];
                }
            }

            return;
        }

        go(y, x, len/2, l);
        go(y, x + len/2, len/2, l);
        go(y + len/2, x, len/2, l);
        go(y + len/2, x + len/2, len/2, l);
    }
}
