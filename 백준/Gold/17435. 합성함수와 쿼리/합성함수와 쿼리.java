import java.io.*;
import java.util.*;

public class Main {

    static int n, log = 20;
    static int[] arr;
    static int[][] spareArr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        spareArr = new int[log][n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        makeSpareArr();

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            sb.append(findV(n, v)).append('\n');
        }

        System.out.print(sb);
    }

    static void makeSpareArr() {
        for(int i = 1; i <= n; i++) {
            spareArr[0][i] = arr[i];
        }

        for(int k = 1; k < log; k++) {
            for(int i = 1; i <= n; i++) {
                int next = spareArr[k-1][i];
                spareArr[k][i] = spareArr[k-1][next];
            }
        }
    }

    static int findV(int n, int v) {
        for(int b = 0; b < log; b++) {
            if((n & (1 << b)) > 0) {
                v = spareArr[b][v];
            }
        }

        return v;
    }
}
