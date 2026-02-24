import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] cnt, parent;
    static List<Integer>[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            n = Integer.parseInt(br.readLine());

            if(n == 0) break;

            cnt = new int[n+1];
            parent = new int[n+1];
            tree = new ArrayList[n+1];
            for(int i = 1; i <= n; i++) {
                tree[i] = new ArrayList<>();
                parent[i] = -1;
            }

            for(int i = 1; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int v = Integer.parseInt(st.nextToken());
                cnt[v] = Integer.parseInt(st.nextToken());

                int childCnt = Integer.parseInt(st.nextToken());
                for(int j = 0; j < childCnt; j++) {
                    int child = Integer.parseInt(st.nextToken());
                    parent[child] = v;
                    tree[v].add(child);
                }
            }
            for(int i = 1; i <= n; i++) {
                if(parent[i] == -1) {
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

    static int dfs(int node) {
        int pp = cnt[node] - 1;
        
        for(int next : tree[node]) {
            pp += dfs(next);
        }

        return cnt[node] = pp;
    }
}
