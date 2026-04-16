import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        long[] fact = new long[21];
        boolean[] visited = new boolean[21];

        Arrays.fill(fact, 1L);
        for(int i = 1; i <= n; i++) {
            fact[i] = fact[i-1] * i;
        }

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        long t = Long.parseLong(st.nextToken());
        if(t == 1) {
            long k = Long.parseLong(st.nextToken());

            for(int i = 0; i < n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(visited[j]) continue;

                    if(fact[n - i - 1] < k) {
                        k -= fact[n - i - 1];
                    } else {
                        arr[i] = j;
                        visited[j] = true;
                        break;
                    }
                }
            }
            for(int i = 0; i < n; i++) {
                sb.append(arr[i]).append(" ");
            }
        } else {
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            long ans = 1;

            for(int i = 0; i < n; i++) {
                for(int j = 1; j < arr[i]; j++) {
                    if(visited[j]) continue;
                    ans += fact[n - i - 1];
                }
                visited[arr[i]] = true;
            }
            
            sb.append(ans);
        }
        
        bw.write(sb.toString());
        bw.flush();
        
        bw.close();
        br.close();
    }
}
