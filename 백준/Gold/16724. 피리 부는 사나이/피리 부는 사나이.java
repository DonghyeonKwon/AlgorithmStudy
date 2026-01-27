import java.io.*;
import java.util.*;

public class Main {
    static int n, m, vid = 0;
    static char[][] map;
    static boolean[][] visited;
    static int[][] seen;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        seen =  new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j]) {
                    vid++;
                    if(bfs(i, j)) cnt++;
                }
            }
        }

        System.out.print(cnt);
    }

    static boolean bfs(int y, int x) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y, x});
        visited[y][x] = true;
        seen[y][x] = vid;

        while(!q.isEmpty()) {
            int[] pos = q.poll();

            int ny = pos[0];
            int nx = pos[1];
            if(map[ny][nx] == 'D') {
                ny += 1;
            } else if(map[ny][nx] == 'R') {
                nx += 1;
            } else if(map[ny][nx] == 'L') {
                nx -= 1;
            } else if(map[ny][nx] == 'U') {
                ny -= 1;
            }

            if(seen[ny][nx] == vid) break;
            if(visited[ny][nx]) return false;

            visited[ny][nx] = true;
            seen[ny][nx] = vid;
            q.add(new int[]{ny, nx});
        }

        return true;
    }
}