import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static Shark[] arr;
    static Smell[][] sMap;

    static int[] dy = {0, -1, 1, 0, 0};
    static int[] dx = {0, 0, 0, -1, 1};
    static int[][][] dd;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new Shark[m+1];
        sMap = new Smell[n][n];
        dd = new int[m+1][5][4];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                sMap[i][j] = new Smell(num, num == 0 ? 0 : k);

                if(num > 0) {
                    arr[num] = new Shark(i, j, 0);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= m; i++) {
            arr[i].d = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= 4; j++) {
                st = new StringTokenizer(br.readLine());
                for(int d = 0; d < 4; d++) {
                    dd[i][j][d] = Integer.parseInt(st.nextToken());
                }
            }
        }

        int ans = simulation();
        System.out.print(ans);
    }

    static int simulation() {
        int t = 0;
        while(t < 1000) {
            t++;

            Smell[][] temp = new Smell[n][n];
            for(int idx = 1; idx <= m; idx++) {
                if(arr[idx].d == -1) continue;

                Shark s = arr[idx];
                int nextD1 = 0, nextD2 = 0;
                for(int i = 0; i < 4; i++) {
                    int ny = s.y + dy[dd[idx][s.d][i]];
                    int nx = s.x + dx[dd[idx][s.d][i]];

                    if(ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                    if(sMap[ny][nx].idx > 0 && sMap[ny][nx].idx != idx) continue;
                    if(sMap[ny][nx].idx == 0) {
                        nextD1 = dd[idx][s.d][i];
                        break;
                    }
                    if(nextD2 == 0)nextD2 = dd[idx][s.d][i];
                }

                int nextD = nextD1 == 0 ? nextD2 : nextD1;
                s.y += dy[nextD];
                s.x += dx[nextD];
                s.d = nextD;

                if(temp[s.y][s.x] != null) {
                    if(temp[s.y][s.x].idx < idx) {
                        s.d = -1;
                    } else {
                        arr[temp[s.y][s.x].idx].d = -1;
                        temp[s.y][s.x].idx = idx;
                    }
                } else {
                    temp[s.y][s.x] = new Smell(idx, k);
                }
            }


            int cnt = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(temp[i][j] == null) {
                        sMap[i][j].s -= 1;
                        if(sMap[i][j].s == 0) sMap[i][j].idx = 0;
                    } else {
                        sMap[i][j] = temp[i][j];
                        cnt++;
                    }
                }
            }


            if(cnt == 1) return t;
        }

        return -1;
    }

    static class Shark {
        int y, x, d;

        Shark(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }

    static class Smell {
        int idx;
        int s;

        Smell(int idx, int s) {
            this.idx = idx;
            this.s = s;
        }
    }
}
