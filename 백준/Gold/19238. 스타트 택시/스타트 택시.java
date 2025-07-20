import java.io.*;
import java.util.*;

public class Main {
    static int n, m, ty, tx, tc;
    static int[][] map;
    static int[] sy, sx, ey, ex;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        tc = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];
        sy = new int[m+1];
        sx = new int[m+1];
        ey = new int[m+1];
        ex = new int[m+1];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) map[i][j] = -1;
            }
        }

        st = new StringTokenizer(br.readLine());
        ty = Integer.parseInt(st.nextToken());
        tx = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());

            sy[i] = Integer.parseInt(st.nextToken());
            sx[i] = Integer.parseInt(st.nextToken());
            ey[i] = Integer.parseInt(st.nextToken());
            ex[i] = Integer.parseInt(st.nextToken());

            map[sy[i]][sx[i]] = i;
        }

        for(int t = 0; t < m; t++) {
            int val = customerBfs(ty, tx);

            if(val == -1 || tc - val < 0) {
                tc = -1;
                break;
            }

            tc -= val;
            int num = map[ty][tx];

            int goalVal = goalBfs(ty, tx, num);
            if(goalVal == -1 || tc - goalVal < 0) {
                tc = -1;
                break;
            }

            tc += goalVal;
            map[sy[num]][sx[num]] = 0;

        }

        System.out.print(tc);

    }

    static int customerBfs(int y, int x) {
        PriorityQueue<Position> q = new PriorityQueue<>();
        boolean[][] visited = new boolean[n+1][n+1];

        visited[y][x] = true;
        q.offer(new Position(y, x, 0));

        while(!q.isEmpty()) {
            Position pos = q.poll();
            y = pos.y;
            x = pos.x;

            if(map[y][x] > 0) {
                ty = y;
                tx = x;
                return pos.val;
            }

            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 1 || ny > n || nx < 1 || nx > n) continue;
                if(map[ny][nx] == -1) continue;
                if(visited[ny][nx]) continue;

                q.offer(new Position(ny, nx, pos.val + 1));
                visited[ny][nx] = true;
            }
        }

        return -1;
    }

    static int goalBfs(int y, int x, int num) {
        PriorityQueue<Position> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[n+1][n+1];

        pq.offer(new Position(y, x, 0));
        visited[y][x] = true;

        while(!pq.isEmpty()) {
            Position pos = pq.poll();

            y = pos.y;
            x = pos.x;

            if(y == ey[num] && x == ex[num]) {
                ty = y;
                tx = x;
                return pos.val;
            }

            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 1 || ny > n || nx < 1 || nx > n) continue;
                if(visited[ny][nx]) continue;
                if(map[ny][nx] == -1) continue;

                pq.offer(new Position(ny, nx, pos.val + 1));
                visited[ny][nx] = true;
            }
        }

        return -1;
    }

    static class Position implements Comparable<Position>{
        int y, x, val;

        Position(int y, int x, int val) {
            this.y = y;
            this.x = x;
            this.val = val;
        }

        @Override
        public int compareTo(Position o){
            if(this.val == o.val) {
                if(this.y == o.y) {
                    return this.x - o.x;
                }
                return this.y - o.y;
            }
            return this.val - o.val;
        }
    }

}
