import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] visited = new int[101][101];
        while(n-- > 0) {
            st = new StringTokenizer(br.readLine());

            int sy = Integer.parseInt(st.nextToken());
            int sx = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());

            for(int i = sy; i <= ey; i++) {
                for(int j = sx; j <= ex; j++) {
                    visited[i][j]++;
                }
            }
        }

        int cnt = 0;
        for(int i = 1; i <= 100; i++) {
            for(int j = 1; j <= 100; j++) {
                if(visited[i][j] > m) {
                    cnt++;
                }
            }
        }

        System.out.print(cnt);
    }
}
