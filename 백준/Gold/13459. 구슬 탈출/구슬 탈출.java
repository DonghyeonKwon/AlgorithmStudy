import java.io.*;
import java.util.*;

public class Main {

    static int r, c, ry, rx, by, bx;
    static char[][] map;
    static boolean[][][][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        visited = new boolean[r][c][r][c];

        for(int i = 0; i < r; i++) {
            char[] arr = br.readLine().toCharArray();

            for(int j = 0; j < c; j++) {
                map[i][j] = arr[j];
                if(arr[j] == 'R') {
                    ry = i;
                    rx = j;
                } else if(arr[j] == 'B') {
                    by = i;
                    bx = j;
                }
            }
        }

        System.out.print(bfs());
    }

    static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {ry, rx, by, bx});
        int cnt = 0;

        while(!q.isEmpty() && cnt < 10) {
            int len = q.size();

            for(int i = 0; i < len; i++) {
                int[] now = q.poll();
                for(int d = 0; d < 4; d++) {
                    int[] cur = now.clone();
                    if(move(cur, d)) {
                        if(map[cur[0]][cur[1]] == 'O') return 1;
                        if(visited[cur[0]][cur[1]][cur[2]][cur[3]]) continue;
                        visited[cur[0]][cur[1]][cur[2]][cur[3]] = true;
                        q.add(new int[] {cur[0], cur[1], cur[2], cur[3]});
                    }
                }
            }

            cnt++;
        }

        return 0;
    }

    static boolean move(int[] cur, int d) {
        boolean redFirst = false;

        if(d == 0 && cur[0] < cur[2]) redFirst = true;
        if(d == 1 && cur[0] > cur[2]) redFirst = true;
        if(d == 2 && cur[1] < cur[3]) redFirst = true;
        if(d == 3 && cur[1] > cur[3]) redFirst = true;

        int ny = cur[0];
        int nx = cur[1];

        while(true) {
            ny += dy[d];
            nx += dx[d];

            if(map[ny][nx] == '#') break;
            cur[0] = ny;
            cur[1] = nx;
            if(map[ny][nx] == 'O') break;
        }

        ny = cur[2];
        nx = cur[3];

        while(true) {
            ny += dy[d];
            nx += dx[d];

            if(map[ny][nx] == '#') break;
            cur[2] = ny;
            cur[3] = nx;
            if(map[ny][nx] == 'O') break;
        }

        if(map[cur[2]][cur[3]] == 'O') return false;

        if(cur[0] == cur[2] && cur[1] == cur[3]) {
            switch(d) {
                case 0:
                    if(redFirst) cur[2]++;
                    else cur[0]++;
                    break;
                case 1:
                    if(redFirst) cur[2]--;
                    else cur[0]--;
                    break;
                case 2:
                    if(redFirst) cur[3]++;
                    else cur[1]++;
                    break;
                case 3:
                    if(redFirst) cur[3]--;
                    else cur[1]--;
                    break;
            }
        }

        return true;
    }
}
