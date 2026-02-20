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

        dfs(1, 0, new int[m]);

        System.out.print(sb);
    }

    static void dfs(int idx, int cnt, int[] arr) {
        if(cnt == m) {
            for(int i = 0; i < m; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        if(idx > n) return;

        for(int i = idx; i <= n; i++) {
            arr[cnt] = i;
            dfs(i+1, cnt + 1, arr);
        }
    }
}
