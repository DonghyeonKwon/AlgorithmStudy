import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, max = -1;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            visited[i] = true;
            combi(arr[i], 1, 0);
            visited[i] = false;
        }

        bw.write(Integer.toString(max));
        bw.flush();
    }

    static void combi(int prev, int cnt, int sum){
        if(cnt == N){
            max = Math.max(max,sum);
            return;
        }

        for(int i = 0; i < N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            int a = Math.abs(prev - arr[i]);
            combi(arr[i], cnt+1, sum+a);
            visited[i] = false;
        }
    }

}
