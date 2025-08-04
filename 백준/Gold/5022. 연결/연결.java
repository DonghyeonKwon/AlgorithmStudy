import java.io.*;
import java.util.*;

public class Main {

    static int n, m, min = Integer.MAX_VALUE, k;
    static Point[] p = new Point[4];
    static Point[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            p[i] = new Point(y, x, 0);
        }

        int ans1 = bfs(p[0], p[1], p[2], p[3]);
        int ans2 = bfs(p[2], p[3], p[0], p[1]);
        
        min = Math.min(ans1, ans2);

        if(min == Integer.MAX_VALUE) {
            System.out.print("IMPOSSIBLE");
        } else {
            System.out.print(min);
        }
    }

    static int bfs(Point a1, Point a2, Point b1, Point b2) {
        int alen = 0;
        int blen = 0;

        map = new Point[n+1][m+1];
        visited = new boolean[n+1][m+1];

        Queue<Point> q = new ArrayDeque<>();
        q.add(a1);

        visited[a1.y][a1.x] = true;
        visited[b1.y][b1.x] = true;
        visited[b2.y][b2.x] = true;
        while(!q.isEmpty()) {
            Point now = q.poll();
            if(now.x == a2.x && now.y == a2.y){
                alen = now.d;
                break;
            }

            for(int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                int dist = now.d + 1;
                if(ny < 0 || ny > n || nx < 0 || nx > m) continue;
                if(visited[ny][nx]) continue;
                
                q.add(new Point(ny, nx, dist));
                visited[ny][nx] = true;
                map[ny][nx] = now;
            }
        }
        
        visited = new boolean[n+1][m+1];
        
        Point now = a2;
        while(true) {
            visited[now.y][now.x] = true;
            if(now.x == a1.x && now.y == a1.y) break;
            now = map[now.y][now.x];
        }
        
        q = new ArrayDeque<>();
        q.add(b1);
        visited[b1.y][b1.x] = true;
        
        while(!q.isEmpty()) {
            now = q.poll();
            if(now.x == b2.x && now.y == b2.y) {
                blen = now.d;
                break;
            }
            
            for(int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                int dist = now.d + 1;
                
                if(ny < 0 || ny > n || nx < 0 || nx > m) continue;
                if(visited[ny][nx]) continue;
                
                q.add(new Point(ny, nx, dist));
                visited[ny][nx] = true;
                map[ny][nx] = now;
            }
        }
        if(blen == 0) return Integer.MAX_VALUE;
        else return alen + blen;
    }

    static class Point {
        int y, x, d;

        Point(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }
}
