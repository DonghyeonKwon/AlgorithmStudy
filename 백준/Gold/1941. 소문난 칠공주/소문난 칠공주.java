import java.io.*;
import java.util.*;

public class Main {
    static int res = 0;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static char[][] map = new char[5][5];
    static boolean[][] tmap = new boolean[5][5], visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 5; i++) {
            map[i] = br.readLine().toCharArray();
        }

        go(0, 0);

        System.out.println(res);
    }

    static void go(int idx, int cnt) {
        if(cnt == 7) {
            visited = new boolean[5][5];
            boolean flag = false;
            loop : for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 5; j++) {
                    if(tmap[i][j] && !visited[i][j]) {
                        flag = bfs(i, j);
                        break loop;
                    }
                }
            }

            if(flag) {
                res++;
            }
            return;
        }

        for(int i = idx; i < 25; i++) {
            tmap[i/5][i%5] = true;
            go(i+1, cnt+1);
            tmap[i/5][i%5] = false;
        }
    }

    static boolean bfs(int y, int x) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{y,x});
        visited[y][x] = true;

        int[] arr = {0, 0};
        if(map[y][x] == 'Y') arr[1]++;
        else arr[0]++;

        while(!q.isEmpty()) {
            int[] pos = q.poll();
            y = pos[0];
            x = pos[1];

            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 0 || nx < 0 || ny >= 5 || nx >= 5) continue;
                if(!tmap[ny][nx]) continue;
                if(visited[ny][nx]) continue;

                if(map[ny][nx] == 'Y') arr[1]++;
                else arr[0]++;

                q.offer(new int[]{ny,nx});
                visited[ny][nx] = true;
            }
        }

        if(arr[0] + arr[1] == 7 && arr[0] >= 4) return true;
        return false;
    }
}
