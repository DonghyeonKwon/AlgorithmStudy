import java.io.*;
import java.util.*;

public class Main {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];

        for(int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int hy = 0, hx = 0;
        ll : for(int i = 0; i < n; i++) {
            loop : for(int j = 0; j < n; j++) {
                if(map[i][j] == '*') {
                    for(int d = 0; d < 4; d++) {
                        int ny = i + dy[d];
                        int nx = j + dx[d];

                        if(ny < 0|| ny >= n || nx < 0 || nx >= n) continue;
                        if(map[ny][nx] != '*') continue loop;
                    }

                    hy = i;
                    hx = j;

                    break ll;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(hy+1).append(" ").append(hx+1).append('\n');

        int ty = hy, tx = hx;
        int cnt = 0;
        while(true) {
            tx -= 1;
            if(tx < 0) break;
            if(map[ty][tx] != '*') break;
            cnt++;
        }
        sb.append(cnt).append(' ');

        tx = hx;
        cnt = 0;
        while(true) {
            tx += 1;
            if(tx >= n) break;
            if(map[ty][tx] != '*') break;
            cnt++;
        }
        sb.append(cnt).append(' ');

        tx = hx;
        cnt = 0;
        while(true) {
            ty += 1;
            if(map[ty][tx] != '*') break;
            cnt++;
        }
        sb.append(cnt).append(' ');

        int ly = ty;
        int lx = hx - 1;
        cnt = 1;
        while(true) {
            ly += 1;
            if(ly >= n) break;
            if(map[ly][lx] != '*') break;
            cnt++;
        }
        sb.append(cnt).append(' ');

        ly = ty;
        lx = hx + 1;
        cnt = 1;
        while(true) {
            ly += 1;
            if(ly >= n) break;
            if(map[ly][lx] != '*') break;
            cnt++;
        }
        sb.append(cnt);

        System.out.print(sb);
    }
}
