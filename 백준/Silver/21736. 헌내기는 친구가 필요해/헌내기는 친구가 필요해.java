import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static char[][] map;
    static boolean[][] visited;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];
        int sy = 0, sx = 0;

        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j);
                if(map[i][j] == 'I') {
                    sy = i;
                    sx = j;
                }
            }
        }

        int ans = bfs(sy, sx);

        if(ans == 0) {
            System.out.println("TT");
        } else {
            System.out.println(ans);
        }
    }

    static int bfs(int y, int x) {
        Queue<int[]> q = new ArrayDeque<>();
        visited[y][x] = true;
        q.add(new int[] {y, x});

        int cnt = 0;

        while(!q.isEmpty()) {
            int[] pos = q.poll();

            for(int i = 0; i < 4; i++) {
                int ny = pos[0] + dy[i];
                int nx = pos[1] + dx[i];

                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if(map[ny][nx] == 'X') continue;
                if(visited[ny][nx]) continue;

                if(map[ny][nx] == 'P') cnt++;
                visited[ny][nx] = true;
                q.add(new int[]{ny, nx});
            }
        }

        return cnt;
    }
}
