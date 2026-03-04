import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        go(0, 0, new int[m]);
        
        System.out.print(sb);
    }

    static void go(int idx, int cnt, int[] brr) {
        if(cnt == m) {
            for(int i = 0; i < m; i++) {
                sb.append(brr[i]).append(' ');
            }
            sb.append('\n');

            return;
        }


        int prev = -1;
        for(int i = idx; i < n; i++) {
            if(visited[i]) continue;
            if(prev == arr[i]) continue;

            brr[cnt] = arr[i];
            prev = arr[i];
            visited[i] = true;
            go(i+1, cnt + 1, brr);
            visited[i] = false;
        }
    }
}
