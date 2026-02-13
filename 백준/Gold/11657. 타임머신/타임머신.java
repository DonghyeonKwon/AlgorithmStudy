import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static final long INF = Long.MAX_VALUE;
    static long[] values;
    static int[][] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new int[m][3];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        values = new long[n+1];
        Arrays.fill(values, INF);

        boolean flag = bellman_ford();
        if(flag) {
            System.out.print(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i <= n; i++) {
                sb.append(values[i] == INF ? -1 : values[i]).append('\n');
            }
            System.out.print(sb);
        }
    }

    static boolean bellman_ford() {
        values[1] = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int from = list[j][0];
                int to = list[j][1];
                int cost = list[j][2];

                if(values[from] != INF && values[to] > values[from] + cost) {
                    values[to] = values[from] + cost;
                    if(i == n - 1) return true;
                }
            }
        }

        return false;
    }
}
