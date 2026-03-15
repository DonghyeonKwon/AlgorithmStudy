import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<Integer>[] list;
    static boolean[] visited;
    static int[] value, value2, far;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }

        visited = new boolean[n+1];
        value = new int[n+1];
        value2 = new int[n+1];
        far = new int[n+1];

        Pair p = dfs(1);
        visited = new boolean[n+1];
        Pair result = dfs(p.node);

        System.out.print((result.val + 1) / 2);
    }

    static Pair dfs(int node) {
        Pair p = new Pair(node, 0);
        visited[node] = true;

        for(int next : list[node]) {
            if(visited[next]) continue;
            Pair x = dfs(next);
            x.val += 1;
            if(x.val > p.val) {
                p = x;
            }
        }

        return p;
    }

    static class Pair{
        int node, val;

        Pair(int node, int val) {
            this.node = node;
            this.val = val;
        }
    }
}
