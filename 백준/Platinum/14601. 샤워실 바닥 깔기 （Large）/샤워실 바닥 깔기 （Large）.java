import java.io.*;
import java.util.*;

public class Main {
    static int n, y, x, cnt = 0;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        x = Integer.parseInt(input[0]);
        y = Integer.parseInt(input[1]);

        n = pow(k);
        map = new int[n+1][n+1];
        y = n - y + 1;
        map[y][x] = -1;

        go(1, 1, n);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                sb.append(map[i][j] + " ");
            }
            sb.append('\n');
        }
        sb.append('\n');

        System.out.print(sb);
    }

    static void go(int y, int x, int size) {
        cnt++;

        int hs = size / 2;
        if(check(y, x, hs)) map[y+hs-1][x+hs-1] = cnt;
        if(check(y+hs, x, hs)) map[y+hs][x+hs-1] = cnt;
        if(check(y, x+hs, hs)) map[y+hs-1][x+hs] = cnt;
        if(check(y+hs, x+hs, hs)) map[y+hs][x+hs] = cnt;

        if(size == 2) return;
        go(y, x, hs);
        go(y, x + hs, hs);
        go(y + hs, x, hs);
        go(y + hs, x + hs, hs);
    }

    static boolean check(int y, int x, int size) {
        for(int i = y; i < y + size; i++) {
            for(int j = x; j < x + size; j++) {
                if(map[i][j] != 0) return false;
            }
        }

        return true;
    }

    static int pow(int k) {
        if(k == 1) return 2;
        return pow(k/2) * pow(k/2) * ((k % 2 == 1) ? 2 : 1);
    }
}
