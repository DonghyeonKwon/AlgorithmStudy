import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k, res = 0, a, b;
    static int[][] map;
    static int[][] sticker;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for(int stk = 0; stk < k; stk++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            sticker = new int[a][b];

            int cnt = 0;
            for(int i = 0; i < a; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < b; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                    if(sticker[i][j] == 1) cnt++;
                }
            }

            go(cnt);
        }

        System.out.print(res);
    }

    static void go(int cnt) {
        for(int r = 0; r < 4; r++) {

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(i + a > n || j + b > m) continue;

                    boolean flag = true;
                    out:for(int ii = 0; ii < a; ii++) {
                        for(int jj = 0; jj < b; jj++) {
                            if(map[i + ii][j + jj] == 1 &&
                                sticker[ii][jj] == 1) {
                                flag = false;
                                break out;
                            }
                        }
                    }

                    if(flag) {
                        for(int ii = 0; ii < a; ii++) {
                            for(int jj = 0; jj < b; jj++) {
                                if(sticker[ii][jj] == 1) map[i + ii][j + jj] = 1;
                            }
                        }

                        res += cnt;
                        return;
                    }
                }
            }

            if(r == 3) break;
            rotate(r);
        }
    }

    static void rotate(int r) {
        int R = a, C = b;
        int nR = b, nC = a;

        int[][] tmpMap = new int[nR][nC];

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                tmpMap[j][nC - 1 - i] = sticker[i][j];
            }
        }

        sticker = new int[nR][nC];
        a = nR;
        b = nC;

        for(int i = 0; i < a; i++) {
            for(int j = 0; j < b; j++) {
                sticker[i][j] = tmpMap[i][j];
            }
        }
    }
}
