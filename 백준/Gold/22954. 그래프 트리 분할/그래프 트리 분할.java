import java.io.*;
import java.util.*;

public class Main {

    static int n, m, dfsCount = 0;
    static boolean[] visited;
    static List<Edge>[] list;
    static List<Integer> edgePath;
    static List<Integer> nodePath;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        if(n <= 2) {
            System.out.print(-1);
            return;
        }

        visited = new boolean[n+1];
        list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(new Edge(i, v));
            list[v].add(new Edge(i, u));
        }

        for(int i = 1; i <= n; i++) {
            if(visited[i]) continue;


            if(dfsCount == 2) {
                System.out.print(-1);
                return;
            }
            visited[i] = true;
            dfsCount++;

            edgePath = new ArrayList<>();
            nodePath = new ArrayList<>();
            nodePath.add(i);
            dfs(i);

            if(edgePath.size() == n - 1) {
                calc();
                break;
            }

            if(dfsCount == 1) {
                if(2 * nodePath.size() == n) {
                    System.out.print(-1);
                    return;
                }

                sb.append(nodePath.size()).append(" ").append(n - nodePath.size()).append('\n');
            }

            for(int node : nodePath) {
                sb.append(node).append(" ");
            }
            sb.append('\n');

            for(int edge : edgePath) {
                sb.append(edge).append(" ");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static void calc() {
        sb.append(n - 1).append(' ').append(1).append('\n');

        for(int i = 0; i < nodePath.size() - 1; i++) {
            sb.append(nodePath.get(i)).append(" ");
        }

        sb.append('\n');

        for(int i = 0; i < edgePath.size() - 1; i++) {
            sb.append(edgePath.get(i)).append(" ");
        }

        sb.append('\n');

        sb.append(nodePath.get(nodePath.size() - 1)).append('\n');
    }

    static void dfs(int node) {

        for(Edge edge : list[node]) {
            if(visited[edge.u]) continue;
            visited[edge.u] = true;
            edgePath.add(edge.num);
            nodePath.add(edge.u);

            dfs(edge.u);
        }
    }

    static class Edge {
        int num, u;

        Edge(int num, int u) {
            this.num = num;
            this.u = u;
        }
    }
}
