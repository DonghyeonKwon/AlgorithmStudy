import java.io.*;
import java.util.*;

public class Main {
    static int n, black = 0, white = 0;
    static int[][] map;
    static boolean[][] visited;

    static int[] dy = {-1, -1, 1, 1};
    static int[] dx = {-1, 1, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0, 0);
        dfs(0, 1, 1, 0);

        System.out.print(black + white);
    }

    static void dfs(int y, int x, int color, int cnt) {
        if(y == n) {
            if(color == 0) {
                black = Math.max(cnt, black);
            } else {
                white = Math.max(cnt, white);
            }
            return;
        }

        int ny = y;
        int nx = x + 2;

        if(nx >= n) {
            ny += 1;
            if(color == 0) nx = ny % 2 == 0 ? 0 : 1;
            else nx =  ny % 2 == 0 ? 1 : 0;
        }

        if(map[y][x] == 0) {
            dfs(ny, nx, color, cnt);
            return;
        }

        if(check(y, x)) {
            visited[y][x] = true;
            dfs(ny, nx, color, cnt + 1);
            visited[y][x] = false;
        }
        dfs(ny, nx, color, cnt);
    }

    static boolean check(int y, int x) {
        if(visited[y][x]) return false;

        for(int d = 0; d < 4; d++) {

            int ny = y + dy[d];
            int nx = x + dx[d];
            while(0 <= ny && ny < n && 0 <= nx && nx < n) {
                if(visited[ny][nx]) return false;
                ny += dy[d];
                nx += dx[d];
            }
        }

        return true;
    }
}
