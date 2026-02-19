import java.io.*;
import java.util.*;

public class Main {
    static int n, k, cnt = 0;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        go(0, 0, 500);

        System.out.print(cnt);
    }

    static void go(int idx, int visited, int w) {
        if(idx == n) {
            cnt++;
            return;
        }

        for(int i = 0; i < n; i++) {
            if((visited & (1 << i)) > 0) continue;
            int nextW = w + arr[i] - k;
            if(nextW < 500) continue;

            go(idx + 1, visited | (1 << i), nextW);
        }
    }
}
