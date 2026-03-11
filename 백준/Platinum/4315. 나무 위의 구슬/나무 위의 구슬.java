import java.io.*;
import java.util.*;

public class Main {
    static int[] cnt, parent;
    static List<Integer>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;

            list = new ArrayList[n+1];
            cnt = new int[n+1];
            parent = new int[n+1];
            for(int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
            }

            for(int i = 1; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                cnt[a] = Integer.parseInt(st.nextToken());

                int m = Integer.parseInt(st.nextToken());
                for(int j = 0; j < m; j++) {
                    int b = Integer.parseInt(st.nextToken());
                    list[a].add(b);
                    parent[b] = a;
                }
            }

            for(int i = 1; i <= n; i++) {
                if(parent[i] == 0) {
                    dfs(i);
                    break;
                }
            }

            int sum = 0;
            for(int i = 1; i <= n; i++) {
                sum += Math.abs(cnt[i]);
            }

            sb.append(sum).append('\n');
        }

        System.out.print(sb);
    }

    static int dfs(int now) {
        int pp = cnt[now] - 1;
        for(int next : list[now]) {
            pp += dfs(next);
        }
        return cnt[now] = pp;
    }
}
