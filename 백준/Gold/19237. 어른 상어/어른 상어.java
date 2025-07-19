import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static int[][][] distPriority;
    static int[][] map, smell;
    static Shark[] shark;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        distPriority = new int[m+1][4][4];
        shark = new Shark[m+1];
        map = new int[n+1][n+1];
        smell = new int[n+1][n+1];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > 0) {
                    shark[map[i][j]] = new Shark(i, j, 0);
                    smell[i][j] = k;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= m; i++) {
            shark[i].d = Integer.parseInt(st.nextToken()) - 1;
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 0; j < 4; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < 4; k++) {
                    distPriority[i][j][k] = Integer.parseInt(st.nextToken()) - 1;
                }
            }
        }

        int time = 0;

        while(true) {
            int count = 0;
            for(int i = 1; i <= m; i++) {
                if(shark[i] != null) count++;
            }

            if(count == 1 && shark[1] != null) {
                break;
            }

            if(time >= 1000) {
                time = -1;
                break;
            }

            int[][] tmp = new int[n+1][n+1];

            for(int i = 1; i <= m; i++) {
                if(shark[i] != null){
                    moveShark(tmp, i);
                }
            }

            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(smell[i][j] > 0) {
                        smell[i][j]--;
                    }

                    if(smell[i][j] == 0) {
                        map[i][j] = 0;
                    }
                }
            }

            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(tmp[i][j] > 0) {
                        smell[i][j] = k;
                        map[i][j] = tmp[i][j];
                    }
                }
            }

            time++;
        }

        System.out.print(time);
    }

    static void moveShark(int[][] tmp, int num) {
        boolean flag = false;
        Shark s = shark[num];
        int ny = 0;
        int nx = 0;
        int nd = 0;
        for(int i = 0; i < 4; i++) {
            nd = distPriority[num][s.d][i];
            ny = s.y + dy[nd];
            nx = s.x + dx[nd];

            if(ny >= 1 && ny <= n && nx >= 1 && nx <= n && map[ny][nx] == 0) {
                flag = true;
                break;
            }
        }

        if(!flag) {
            for(int i = 0; i < 4; i++) {
                nd = distPriority[num][s.d][i];
                ny = s.y + dy[nd];
                nx = s.x + dx[nd];

                if(ny >= 1 && ny <= n && nx >= 1 && nx <= n && map[ny][nx] == num) {
                    break;
                }
            }
        }

        if(tmp[ny][nx] == 0) {
            tmp[ny][nx] = num;
            s.y = ny;
            s.x = nx;
            s.d = nd;
        } else {
            shark[num] = null;
        }
    }

    static class Shark{
        int y, x, d;
        Shark(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }
}
