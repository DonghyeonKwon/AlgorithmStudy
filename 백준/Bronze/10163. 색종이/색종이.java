import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];

        int[][] map = new int[1002][1002];

        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            arr[i] = w * h;

            for(int j = x; j < x + w; j++) {
                for(int k = y; k < y + h; k++) {
                    if(map[j][k] != 0) {
                        arr[map[j][k]]--;
                    }
                    map[j][k] = i;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            sb.append(arr[i]).append('\n');
        }

        System.out.print(sb);
    }
}
