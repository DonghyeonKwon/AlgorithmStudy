import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static List<Integer>[] tree;
    static int[] subTree;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n+1];
        subTree = new int[n+1];
        visited = new boolean[n+1];

        for(int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
            subTree[i] = 1;
        }

        for(int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            tree[start].add(end);
            tree[end].add(start);
        }

        visited[1] = true;
        dfs(1);

        long ans = 0;
        for(int i = 2; i <= n; i++) {
            int restNodeCnt = n - subTree[i];

            ans += nC2(n) - nC2(restNodeCnt);
        }

        System.out.print(ans);
    }

    static long nC2(int n) {
        return (long)n * (n - 1) / 2;
    }

    static int dfs(int now) {

        for(int next : tree[now]) {
            if(visited[next]) continue;

            visited[next] = true;
            subTree[now] += dfs(next);
        }

        return subTree[now];
    }
}
