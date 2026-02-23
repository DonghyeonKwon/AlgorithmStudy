import java.io.*;
import java.util.*;

public class Main {
    static int s, N, K, r1, r2, c1, c2, p;
    static int[][] ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        r1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());
        p = (N - K) / 2;

        ans = new int[r2 - r1 + 1][c2 - c1 + 1];

        if(s == 0) {
            System.out.print(0);
            return;
        }

        int maxN = N;

        for(int i = 1; i < s; i++) {
            maxN *= N;
        }

        go(0, 0, maxN, false);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < r2 - r1 + 1; i++) {
            for(int k : ans[i]) {
                sb.append(k);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static void go(int sx, int sy, int cnt, boolean black) {
        if(check(sx, sy, cnt)) {
            if(black) {
                for(int y = sy; y < sy + cnt; y++) {
                    for(int x = sx; x < sx + cnt; x++) {
                        if((r1 <= y && y <= r2) && (c1 <= x && x <= c2)) {
                            ans[y - r1][x - c1] = 1;
                        }
                    }
                }
                return;
            }

            if(cnt == N) {
                for(int y = sy; y < sy + cnt; y++) {
                    for(int x = sx; x < sx + cnt; x++) {
                        if((r1 <= y && y <= r2) && (c1 <= x && x <= c2)) {
                            if(sy + p <= y && y < sy + cnt - p && sx + p <= x && x < sx + cnt - p) {
                                ans[y - r1][x - c1] = 1;
                            } else {
                                ans[y - r1][x - c1] = 0;
                            }
                        }
                    }
                }
                return;
            }

            int nextLen = cnt / N;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    go(sx + nextLen * i, sy + nextLen * j, nextLen, p <= i && i < N - p && p <= j && j < N - p);
                }
            }
        }

    }

    static boolean check(int sx, int sy, int cnt) {
        return !(sx > c2 || sx + cnt - 1 < c1 || sy > r2 || sy + cnt - 1 < r1);
    }
}
