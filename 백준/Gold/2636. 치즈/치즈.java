import java.io.*;
import java.util.*;

public class Main {
    static int r, c, zeroCnt = 0;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        visited = new boolean[r][c];

        for(int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0) zeroCnt++;
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        Queue<int[]> temp = new ArrayDeque<>();

        int time = 0;
        int ans = 0;
        while(true) {
            time++;

            while(!q.isEmpty()) {
                int[] pos = q.poll();
                int y = pos[0];
                int x = pos[1];

                for(int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];

                    if(ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
                    if(visited[ny][nx]) continue;
                    if(map[ny][nx] == 0) {
                        visited[ny][nx] = true;
                        q.add(new int[]{ny, nx});
                    } else {
                        temp.add(new int[]{ny, nx});
                    }
                }
            }

            ans = 0;
            while(!temp.isEmpty()) {
                int[] pos = temp.poll();
                if(map[pos[0]][pos[1]] == 1) {
                    map[pos[0]][pos[1]] = 0;
                    q.add(pos);
                    ans++;
                }
            }

            zeroCnt += ans;
            if(zeroCnt == r * c) {
                break;
            }
        }

        System.out.print(time + "\n" + ans);
    }
}
