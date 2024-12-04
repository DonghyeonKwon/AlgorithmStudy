import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, max = -1;
    static int[] arr, choosed;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        choosed = new int[N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        combi(0);

        bw.write(Integer.toString(max));
        bw.flush();
    }

    static void combi(int idx){
        if(idx == N){
            cal();
            return;
        }

        for(int i = 0; i < N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            choosed[idx] = i;
            combi(idx+1);
            visited[i] = false;
        }
    }

    static void cal() {
        int sum = 0;

        for(int i = 0; i < N-1; i++) {
            sum += Math.abs(arr[choosed[i]] - arr[choosed[i + 1]]);
        }
        max = Math.max(max, sum);
    }
}