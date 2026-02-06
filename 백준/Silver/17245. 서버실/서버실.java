import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static long total = 0;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                total += map[i][j];
            }
        }

        if(total == 0) {
            System.out.print(0);
            return;
        }

        int s = 0;
        int e = 10_000_000;
        int ans = 0;
        while(s <= e) {
            int mid = (s + e) / 2;

            long computerCnt = check(mid);
            if(computerCnt >= ((total+1) / 2)) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }

        System.out.print(ans);
    }

    static long check(int mid) {
        long cnt = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                cnt += Math.min(map[i][j], mid);
            }
        }

        return cnt;
    }
}
