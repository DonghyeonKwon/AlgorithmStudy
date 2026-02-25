import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        int[][] map = new int[n][n];

        int d = 0;
        int cnt = 1;
        int k = 0;
        int y = n / 2, x = n / 2;
        int num = 1;
        int ty = 0, tx = 0;

        loop : while(true) {
            for(int i = 0; i < cnt; i++) {
                if(y < 0) break loop;
                map[y][x] = num++;
                if(map[y][x] == target) {
                    ty = y+1;
                    tx = x+1;
                }
                y += dy[d];
                x += dx[d];
            }

            d = (d + 1) % 4;
            k++;
            if(k % 2 == 0) {
                cnt++;
            }

        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sb.append(map[i][j]).append(' ');
            }
            sb.append('\n');
        }
        sb.append(ty).append(' ').append(tx);

        System.out.print(sb);

    }
}
