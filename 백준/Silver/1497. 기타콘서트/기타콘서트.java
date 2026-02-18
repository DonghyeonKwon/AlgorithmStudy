import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int cnt = 0, ans = -1;
    static long[] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new long[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String g = st.nextToken();
            String k = st.nextToken();
            for(int j = 0; j < m; j++) {
                if(k.charAt(j) == 'Y') {
                    map[i] |= (1L << j);
                }
            }
        }

        go(0, 0, 0);

        System.out.print(ans);
    }

    static void go(int idx, int gCnt, long visited) {
        if(visited == (1L << m) - 1) {
            if(cnt < m) {
                cnt = m;
                ans = gCnt;
            } else if(cnt == m) {
                ans = Math.min(ans, gCnt);
            }
            return;
        }

        if(idx == n) {
            int k = 0;
            for(int i = 0; i < m; i++) {
                if((visited & (1L << i)) > 0) k++;
            }

            if(cnt < k) {
                cnt = k;
                ans = gCnt;
            } else if(cnt == k) {
                ans = Math.min(ans, gCnt);
            }

            return;
        }


        go(idx + 1, gCnt, visited);
        if(map[idx] != 0) go(idx + 1, gCnt + 1, visited | map[idx]);
    }
}
