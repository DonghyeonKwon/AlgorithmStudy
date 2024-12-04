import java.io.*;
import java.util.*;

public class Main {
    static int n, k, res = 0;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        combi(0, 500);

        System.out.println(res);
    }

    static void combi(int cnt, int sum){
        if(sum < 500) return;

        if(cnt == n) {
            res++;
            return;
        }

        for(int i = 0; i < n; i++){
            if(visited[i]) continue;
            visited[i] = true;
            combi(cnt+1, sum+arr[i]-k);
            visited[i] = false;
        }
    }
}
