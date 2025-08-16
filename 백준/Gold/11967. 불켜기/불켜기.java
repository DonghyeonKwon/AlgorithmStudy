import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static boolean[][] light;
    static boolean[][] visited;
    static List<int[]>[][] list;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1][n+1];
        light = new boolean[n+1][n+1];
        visited = new boolean[n+1][n+1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                list[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[x][y].add(new int[]{a, b});
        }

        light[1][1] = true;
        visited[1][1] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{1, 1});

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int y = now[0];
            int x = now[1];

            for(int[] arr : list[y][x]) {
                int yy = arr[0];
                int xx = arr[1];

                if(!light[yy][xx] && !visited[yy][xx]) {
                    for(int i = 0; i < 4; i++) {
                        int nyy = yy + dy[i];
                        int nxx = xx + dx[i];

                        if(nyy < 1 || nyy > n || nxx < 1 || nxx > n) continue;
                        if(!visited[nyy][nxx]) continue;
                        q.add(new int[]{nyy, nxx});
                    }
                }

                light[yy][xx] = true;
            }

            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 1 || ny > n || nx < 1 || nx > n) continue;
                if(!light[ny][nx]) continue;
                if(visited[ny][nx]) continue;
                q.add(new int[]{ny, nx});
                visited[ny][nx] = true;
            }
        }

        int cnt = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(light[i][j]) cnt++;
            }
        }

        System.out.print(cnt);
    }

}
