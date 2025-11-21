import java.io.*;
import java.util.*;

public class Main {
    static int n, max = 0, node;
    static boolean[] visited;
    static List<Edge>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        list = new ArrayList[n+1];
        visited = new boolean[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int idx = Integer.parseInt(st.nextToken());

            while(true) {
                int b = Integer.parseInt(st.nextToken());
                if(b == -1) break;

                int len = Integer.parseInt(st.nextToken());
                list[idx].add(new Edge(b, len));
            }
        }

        visited = new boolean[n+1];
        go(1, 0);

        visited = new boolean[n+1];
        go(node, 0);

        System.out.print(max);
    }

    static void go(int idx, int sum) {
        if(sum > max) {
            max = sum;
            node = idx;
        }

        visited[idx] = true;

        for(Edge next : list[idx]) {
            if(visited[next.node]) continue;
            visited[next.node] = true;
            go(next.node, sum + next.len);
        }
    }

    static class Edge {
        int node;
        int len;

        Edge(int node, int len) {
            this.node = node;
            this.len = len;
        }
    }
}
