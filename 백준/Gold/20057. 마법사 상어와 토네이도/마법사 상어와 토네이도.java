import java.io.*;
import java.util.*;

public class Main {
    static double[][] percent = {
            {0,       0, 0.02,    0, 0},
            {0,     0.1, 0.07, 0.01, 0},
            {0.05,    0,    0,    0, 0},
            {0,     0.1, 0.07, 0.01, 0},
            {0,       0, 0.02,    0, 0}
    };

    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int y = n / 2;
        int x = n / 2;
        int goCnt = 0;
        int dist = 1;

        int d = 0;
        int[] dy = {0, 1, 0, -1};
        int[] dx = {-1, 0, 1, 0};

        while(!(y == 0 && x == 0)) {
            for(int i = 0; i < dist; i++) {
                y += dy[d%4];
                x += dx[d%4];

                go(map, y, x, d, n);

                if(y == 0 && x == 0) break;
            }

            goCnt++;
            d++;

            if(goCnt == 2) {
                dist++;
                goCnt = 0;
            }
        }

        System.out.print(answer);
    }

    static int[][] turnPercentArr(int[][] arr) {
        int[][] tmp = new int[5][5];

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                tmp[4-j][i] = arr[i][j];
            }
        }

        return tmp;
    }

    static void go(int[][] map, int y, int x, int d, int n){
        int[][] temp = new int[5][5];

        int send = map[y][x];
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(i == 2 && j == 1) continue;
                int k = (int) (map[y][x] * percent[i][j]);
                temp[i][j] = k;
                send -= k;
            }
        }
        temp[2][1] = send;
        map[y][x] = 0;

        for(int i = 0; i < d%4; i++) {
            temp = turnPercentArr(temp);
        }

        int i = 0, j = 0;
        for(int ny = y - 2; ny <= y + 2; ny++) {
            for(int nx = x - 2; nx <= x + 2; nx++) {

                if(nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    answer += temp[i][j];
                } else {
                    map[ny][nx] += temp[i][j];
                }

                j++;
            }
            j = 0;
            i++;
        }
    }
}
