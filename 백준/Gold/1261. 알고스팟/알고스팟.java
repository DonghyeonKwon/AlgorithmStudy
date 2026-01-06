import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static boolean[][] map;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new boolean[n+1][m+1];
        for(int i = 1; i <= n; i++) {
            String input = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j+1] = input.charAt(j) == '1';
            }
        }

        System.out.print(dijkstra(1, 1));
    }

    static int dijkstra(int y, int x) {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[n+1][m+1];
        pq.add(new Info(y, x, 0, 0));
        visited[y][x] = true;

        while(!pq.isEmpty()) {
            Info now = pq.poll();

            if(now.y == n && now.x == m) {
                return now.cost;
            }

            for(int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                int ndis = now.dis + 1;

                if(ny < 1 || nx < 1 || ny > n || nx > m) continue;
                if(visited[ny][nx]) continue;

                int ncost = now.cost;
                if(map[ny][nx]) {
                    ncost +=1 ;
                }

                visited[ny][nx] = true;
                pq.add(new Info(ny, nx, ndis, ncost));
            }
        }

        return -1;
    }

    static class Info implements Comparable<Info> {
        int y, x, dis, cost;

        Info(int y, int x, int dis, int cost) {
            this.y = y;
            this.x = x;
            this.dis = dis;
            this.cost = cost;
        }

        @Override
        public int compareTo(Info o) {
            if(this.cost == o.cost) {
                return this.dis - o.dis;
            }
            return this.cost - o.cost;
        }
    }
}
