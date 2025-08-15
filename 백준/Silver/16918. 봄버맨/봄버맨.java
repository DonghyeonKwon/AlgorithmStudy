import java.io.*;
import java.util.*;

public class Main {
    static int r, c, n;
    static int[][] map;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[r][c];

        for(int i = 0; i < r; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j = 0; j < c; j++) {
                if(arr[j] == 'O') {
                    map[i][j] = 2;
                }
            }
        }

        int t = 2;
        while(t <= n) {
            setBomb();
            t++;
            if(t > n) break;
            bomb();
            t++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                sb.append(map[i][j] == 0 ? '.' : 'O');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static void setBomb() {
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(map[i][j] > 0) {
                    map[i][j]--;
                } else {
                    map[i][j] = 3;
                }
            }
        }
    }

    static void bomb() {
        int[][] temp = new int[r][c];
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                map[i][j]--;
                temp[i][j] = map[i][j];
            }
        }

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(map[i][j] == 0) {
                    for(int d = 0; d < 4; d++) {
                        int ny = i + dy[d];
                        int nx = j + dx[d];

                        if(ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
                        temp[ny][nx] = 0;
                    }
                }
            }
        }

        map = temp;
    }
}
