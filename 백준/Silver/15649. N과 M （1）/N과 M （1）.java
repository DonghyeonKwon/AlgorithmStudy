import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        go(0, 0, new int[m]);

        System.out.print(sb);
    }

    static void go(int cnt, int visited, int[] arr) {
        if(cnt == m) {
            for(int i = 0; i < m; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');

            return;
        }

        for(int i = 1; i <= n; i++) {
            if((visited & (1 << i)) > 0) continue;
            arr[cnt] = i;
            go(cnt + 1, visited | (1 << i), arr);
        }
    }
}
