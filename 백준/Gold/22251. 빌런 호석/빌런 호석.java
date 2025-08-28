import java.io.*;
import java.util.*;

public class Main {
    static int n, k, p, x, cnt = 0;
    static int[][] dnum = {
            {0, 4, 3, 3, 4, 3, 2, 3, 1, 2},
            {4, 0, 5, 3, 2, 5, 6, 1, 5, 4},
            {3, 5, 0, 2, 5, 4, 3, 4, 2, 3},
            {3, 3, 2, 0, 3, 2, 3, 2, 2, 1},
            {4, 2, 5, 3, 0, 3, 4, 3, 3, 2},
            {3, 5, 4, 2, 3, 0, 1, 4, 2, 1},
            {2, 6, 3, 3, 4, 1, 0, 5, 1, 2},
            {3, 1, 4, 2, 3, 4, 5, 0, 4, 3},
            {1, 5, 2, 2, 3, 2, 1, 4, 0, 1},
            {2, 4, 3, 1, 2, 1, 2, 3, 1, 0},
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        int[] arr = new int[k];
        int tmp = x;
        for(int i = k-1; i >= 0; i--) {
            if(tmp == 0) break;
            arr[i] = tmp % 10;
            tmp /= 10;
        }

        go(arr, 0, 0);

        System.out.print(cnt);
    }

    static void go(int[] arr, int idx, int c) {
        if(idx == k) {
            if(c == 0) return;
            int num = 0;
            for(int i = 0; i < k; i++) {
                num *= 10;
                num += arr[i];
            }

            if(num > n || num == 0) return;
            cnt++;

            return;
        }

        int tmp = arr[idx];
        for(int i = 0; i <= 9; i++) {
            if(dnum[tmp][i] + c <= p) {
                arr[idx] = i;
                go(arr, idx + 1, c + dnum[tmp][i]);
                arr[idx] = tmp;
            }
        }
    }
}
