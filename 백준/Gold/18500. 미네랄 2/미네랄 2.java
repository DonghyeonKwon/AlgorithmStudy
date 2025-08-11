import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static char[][] map;
    static int[][] visited;

    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for(int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int p = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < p; i++) {
            int high = Integer.parseInt(st.nextToken());
            high = n - high;
            boolean flag = crush(i % 2 == 0 ? 0 : m-1, high, i%2);

            if(flag) {
                visited = new int[n][m];
                int cnt = 1;
                int target = -1;
                for(int y = 0; y < n; y++) {
                    for(int x = 0; x < m; x++) {
                        if(visited[y][x] == 0 && map[y][x] == 'x') {
                            int lowY = bfs(y, x, cnt);
                            if(lowY < n-1) {
                                target = cnt;
                            }
                            cnt++;
                        }
                    }
                }

                if(cnt > 2) {
                    Queue<int[]> q = new ArrayDeque<>();
                    for(int x = 0; x < m; x++) {
                        for(int y = n-1; y >= 0; y--) {
                            if (visited[y][x] == target) {
                                q.add(new int[]{y, x, 0});
                            }
                        }
                    }

                    boolean f = true;
                    int breakNum = 1000;
                    while(!q.isEmpty()) {
                        int[] pos = q.poll();

                        if(pos[2] > breakNum) continue;

                        int ny = pos[0] + 1;
                        int nx = pos[1];


                        map[ny][nx] = 'x';
                        map[pos[0]][pos[1]] = '.';

                        if(ny + 1 >= n || (visited[ny+1][nx] != target && visited[ny+1][nx] > 0)) {
                            breakNum = pos[2];
                            continue;
                        }


                        q.add(new int[]{ny, nx, pos[2] + 1});
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(map[i]).append('\n');
        }

        System.out.print(sb);
    }

    static int bfs(int y, int x, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y, x});
        visited[y][x] = c;

        int lowY = -1;

        while(!q.isEmpty()) {
            int[] pos = q.poll();

            lowY = Math.max(lowY, pos[0]);

            for(int i = 0; i < 4; i++) {
                int ny = pos[0] + dy[i];
                int nx = pos[1] + dx[i];

                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if(map[ny][nx] != 'x') continue;
                if(visited[ny][nx] > 0) continue;

                q.add(new int[]{ny, nx});
                visited[ny][nx] = c;
            }
        }

        return lowY;
    }

    static boolean crush(int x, int y, int d) {
        while(0 <= x && x <= m-1) {
            if(map[y][x] == 'x') {
                map[y][x] = '.';
                return true;
            }

            y += dy[d];
            x += dx[d];
        }

        return false;
    }
}
