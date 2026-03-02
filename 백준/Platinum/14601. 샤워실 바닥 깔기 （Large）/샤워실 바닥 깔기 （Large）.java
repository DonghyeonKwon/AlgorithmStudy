import java.io.*;
import java.util.*;

public class Main {
    static int n, y, x, cnt = 0;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        n = (int) Math.pow(2, n);
        map = new int[n+1][n+1];
        y = n - y + 1;
        map[y][x] = -1;

        go(1, 1, n);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                sb.append(map[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static void go(int sy, int sx,  int size) {
        cnt++;

        int half = size / 2;

        if(check(sy, sx, half)) map[sy + half - 1][sx + half - 1] = cnt;
        if(check(sy + half, sx, half)) map[sy + half][sx + half - 1] = cnt;
        if(check(sy, sx + half, half)) map[sy + half - 1][sx + half] = cnt;
        if(check(sy + half, sx + half, half)) map[sy + half][sx + half] = cnt;

        if(size == 2) return;

        go(sy, sx, half);
        go(sy + half, sx, half);
        go(sy, sx + half, half);
        go(sy + half, sx + half, half);
    }

    static boolean check(int y, int x, int s) {
        for(int i = y; i < y + s; i++) {
            for(int j = x; j < x + s; j++) {
                if(map[i][j] != 0) return false;
            }
        }
        return true;
    }
}
