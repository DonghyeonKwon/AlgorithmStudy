import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static char[][] map;
    static boolean[][][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[n+1][m+1];
        for(int i = 1; i <= n; i++) {
            String input = br.readLine();
            for(int j = 1; j <= m; j++) {
                map[i][j] = input.charAt(j-1);
            }
        }
        visited = new boolean[k+1][n+1][m+1];

        System.out.print(go(1, 1));
    }

    static int go(int y, int x) {
        PriorityQueue<Pos> pq = new PriorityQueue<>();
        pq.add(new Pos(y, x, k, 1));
        visited[k][y][x] = true;

        while(!pq.isEmpty()) {
            Pos now = pq.poll();

            if(now.y == n && now.x == m) {
                return now.cost;
            }

            for(int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                int nCost = now.cost + 1;

                if(ny < 1 || ny > n || nx < 1 || nx > m) continue;
                if(map[ny][nx] == '1') {
                    if(now.k == 0) continue;
                    int nk = now.k - 1;
                    if(visited[nk][ny][nx]) continue;
                    visited[nk][ny][nx] = true;
                    pq.add(new Pos(ny, nx, nk, nCost));
                } else {
                    int nk = now.k;
                    if(visited[nk][ny][nx]) continue;
                    visited[nk][ny][nx] = true;
                    pq.add(new Pos(ny, nx, nk, nCost));
                }
            }
        }

        return -1;
    }

    static class Pos implements Comparable<Pos> {
        int y, x, k, cost;

        Pos(int y, int x, int k, int cost) {
            this.y = y;
            this.x = x;
            this.k = k;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pos o) {
            return this.cost - o.cost;
        }
    }
}
