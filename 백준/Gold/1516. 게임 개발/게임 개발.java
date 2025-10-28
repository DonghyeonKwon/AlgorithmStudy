import java.io.*;
import java.util.*;

public class Main {

    int n;
    int[] dp, arr, depth;
    boolean[] visited;
    List<Integer>[] list;

    void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        arr = new int[n+1];
        depth = new int[n+1];
        visited = new boolean[n+1];
        list = new ArrayList[n+1];
        
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i] = Integer.parseInt(st.nextToken());
            while(true) {
                int k = Integer.parseInt(st.nextToken());
                if(k == -1) break;
                list[k].add(i);
                depth[i]++;
            }
        }

        int cnt = 0;
        while(cnt < n) {
            for(int i = 1; i <= n; i++) {
                if(visited[i]) continue;
                if(depth[i] > 0) continue;

                dp[i] += arr[i];
                for(int next : list[i]) {
                    depth[next]--;
                    dp[next] = Math.max(dp[next], dp[i]);
                }
                visited[i] = true;
                cnt++;
            }
        }

        for(int i = 1; i <= n; i++) {
            System.out.println(dp[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

}
