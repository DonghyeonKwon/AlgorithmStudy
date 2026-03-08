import java.io.*;
import java.util.*;

public class Main {
    static int n, total = 0, min = 987654321;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                total += arr[i][j];
            }
        }

        for(int y = 0; y < n; y++) {
            for(int x = 0; x < n; x++) {
                for(int d1 = 1; d1 <= n - 2; d1++) {
                    for(int d2 = 1; d2 <= n - 2; d2++) {
                        if(y + d1 + d2 >= n || x + d2 >= n || x - d1 < 0) continue;
                        check(y, x, d1, d2);
                    }
                }
            }
        }

        System.out.print(min);
    }

    static void check(int y, int x, int d1, int d2) {
        boolean[][] visited = new boolean[n][n];
        for(int i = 0; i <= d1; i++) {
            visited[y + i][x - i] = true;
            visited[y + d2 + i][x + d2 - i] = true;
        }

        for(int i = 0; i <= d2; i++) {
            visited[y+i][x+i] = true;
            visited[y+d1+i][x-d1+i] = true;
        }

        int[] sum = new int[6];
        sum[5] = total;

        //1번
        for(int i = 0; i < y + d1; i++) {
            for(int j = 0; j <= x; j++) {
                if(visited[i][j]) break;
                sum[1] += arr[i][j];
                sum[5] -= arr[i][j];
            }
        }

        //2번
        for(int i = 0; i <= y + d2; i++) {
            for(int j = n-1; j > x; j--) {
                if(visited[i][j]) break;
                sum[2] += arr[i][j];
                sum[5] -= arr[i][j];
            }
        }

        //3번
        for(int i = n-1; i >= y + d1; i--) {
            for(int j = 0; j < x - d1 + d2; j++) {
                if(visited[i][j]) break;
                sum[3] += arr[i][j];
                sum[5] -= arr[i][j];
            }
        }

        //4번
        for(int i = n-1; i > y + d2; i--) {
            for(int j = n-1; j >= x - d1 + d2; j--) {
                if(visited[i][j]) break;
                sum[4] += arr[i][j];
                sum[5] -= arr[i][j];
            }
        }


        int mx = 0;
        int mn = 987654321;
        for(int i = 1; i <= 5; i++) {
            mx = Math.max(mx, sum[i]);
            mn = Math.min(mn, sum[i]);
        }

        if(min > mx - mn) {
            min = mx - mn;
        }
    }
}
