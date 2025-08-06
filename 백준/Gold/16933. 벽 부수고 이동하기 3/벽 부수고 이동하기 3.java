import java.io.*;
import java.util.*;

public class Main {

    static int n, m, k;
    static char[][] map;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        for(int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        System.out.print(go(0, 0));
    }

    static int go(int y, int x) {
        Queue<Pos> q = new ArrayDeque<>();
        boolean[][][][] visited = new boolean[2][k + 1][n][m];
        q.add(new Pos(y, x, 0, 1));
        visited[1][0][0][0] = true;

        while(!q.isEmpty()) {
            Pos now = q.poll();

            if(now.y == n-1 && now.x == m-1) return now.cost;

            for(int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                int ncost = now.cost + 1;

                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;

                if(map[ny][nx] == '0') {
                    if(!visited[ncost % 2][now.k][ny][nx]) {
                        q.add(new Pos(ny, nx, now.k, ncost));
                        visited[ncost % 2][now.k][ny][nx] = true;
                    }
                } else {
                    if(now.k < k && now.cost % 2 == 1 && !visited[ncost%2][now.k + 1][ny][nx]) {
                        visited[ncost%2][now.k + 1][ny][nx] = true;
                        q.add(new Pos(ny, nx, now.k + 1, ncost));
                    } else if(now.k < k && now.cost % 2 == 0 && !visited[ncost%2][now.k][now.y][now.x]) {
                        visited[ncost%2][now.k][now.y][now.x] = true;
                        q.add(new Pos(now.y, now.x, now.k, ncost));
                    }
                }
            }
        }

        return -1;
    }

    static class Pos{
        int y, x, k, cost;

        Pos(int y, int x, int k, int cost) {
            this.y = y;
            this.x = x;
            this.k = k;
            this.cost = cost;
        }
    }
}
