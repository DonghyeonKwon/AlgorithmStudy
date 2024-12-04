import java.io.*;
import java.util.*;

public class Main {
    static int n, m, res = 0;
    static int[] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1][n+1];
        arr = new int[3];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            visited[a][b] = true;
            visited[b][a] = true;
        }

        for(int i = 1; i <= n; i++) {
            arr[0] = i;
            combi(i+1, 1);
        }

        System.out.println(res);
    }

    static void combi(int idx, int cnt){
        if(cnt == 3){
            if(visited[arr[0]][arr[1]] || visited[arr[1]][arr[2]] || visited[arr[2]][arr[0]]) return;
            res++;
            return;
        }

        for(int i = idx; i <= n; i++) {
            arr[cnt] = i;
            combi(i +1, cnt+1);
        }
    }
}