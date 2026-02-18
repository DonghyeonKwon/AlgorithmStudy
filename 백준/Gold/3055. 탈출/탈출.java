import java.io.*;
import java.util.*;

public class Main {
    static int r, c, INF = Integer.MAX_VALUE;
    static Pos D, S;
    static Queue<Pos> q;
    static char[][] map;
    static int[][] fillWater;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        fillWater = new int[r][c];
        visited = new boolean[r][c];
        q = new ArrayDeque<>();

        for(int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();

            for(int j = 0; j < c; j++) {
                fillWater[i][j] = INF;
                if(map[i][j] == 'D') {
                    D = new Pos(i, j, 0);
                } else if(map[i][j] == 'S') {
                    S = new Pos(i, j, 0);
                } else if(map[i][j] == '*') {
                    q.add(new Pos(i, j,0));
                    fillWater[i][j] = 0;
                }
            }
        }

        waterBFS();
        int ans = dochiBFS();
        System.out.print(ans == -1 ? "KAKTUS" : ans);
    }

    static int dochiBFS() {
        q.add(S);
        visited[S.y][S.x] = true;

        while(!q.isEmpty()) {
            Pos now = q.poll();

            if(now.y == D.y && now.x == D.x) {
                return now.c;
            }

            for(int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if(ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
                if(visited[ny][nx]) continue;
                if(map[ny][nx] == 'X') continue;
                if(fillWater[ny][nx] <= now.c + 1) continue;

                visited[ny][nx] = true;
                q.add(new Pos(ny, nx, now.c + 1));
            }
        }

        return -1;
    }

    static void waterBFS() {
        while(!q.isEmpty()) {
            Pos now = q.poll();

            for(int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if(ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
                if(map[ny][nx] == 'X' || map[ny][nx] == 'D') continue;
                if(fillWater[ny][nx] <= now.c + 1) continue;

                fillWater[ny][nx] = now.c + 1;
                q.add(new Pos(ny, nx, now.c + 1));
            }
        }
    }

    static class Pos {
        int y, x, c;

        Pos(int y, int x, int c) {
            this.y = y;
            this.x = x;
            this.c = c;
        }
    }
}
