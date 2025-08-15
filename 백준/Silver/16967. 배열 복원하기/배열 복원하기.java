import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[][] a = new int[h][w];
        int[][] b = new int[h+x][w+y];

        for(int i = 0; i < h + x; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < w + y; j++) {
                b[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                a[i][j] = b[i][j];
                if(i >= x && j >= y) {
                    a[i][j] -= a[i-x][j-y];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                sb.append(a[i][j]).append(" ");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
