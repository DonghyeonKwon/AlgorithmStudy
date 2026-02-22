import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static long max;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        max = calcB();


        for(int i = 1; i < n - 1; i++) {
            swapR(0, i);
            max = Math.max(max, calcB());
            swapR(0, i);

            swapR(n - 1, i);
            max = Math.max(max, calcB());
            swapR(n - 1, i);
        }

        for(int i = 1; i < m - 1; i++) {
            swapC(0, i);
            max = Math.max(max, calcB());
            swapC(0, i);

            swapC(m - 1, i);
            max = Math.max(max, calcB());
            swapC(m - 1, i);
        }

        System.out.print(max);
    }

    static void swapR(int i, int j) {
        int[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void swapC(int i, int j) {
        for(int y = 0; y < n; y++) {
            int temp = arr[y][i];
            arr[y][i] = arr[y][j];
            arr[y][j] = temp;
        }
    }

    static long calcB() {
        long sum = 0;
        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < m - 1; j++) {
                sum += arr[i][j] + arr[i+1][j] + arr[i][j+1] + arr[i+1][j+1];
            }
        }

        return sum;
    }
}
