import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<Edge>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[u].add(new Edge(v, c));
            list[v].add(new Edge(u, c));
        }

        System.out.print(dijkstra());
    }

    static int dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] value = new int[n+1];
        boolean[] visited = new boolean[n+1];

        Arrays.fill(value, Integer.MAX_VALUE);
        pq.add(new Edge(1, 0));
        value[1] = 0;

        int result = 0;
        while(!pq.isEmpty()) {
            Edge now = pq.poll();

            if(visited[now.v]) continue;
            visited[now.v] = true;

            if(now.v == n) {
                result = now.c;
                break;
            }

            for(Edge next : list[now.v]) {
                if(!visited[next.v] && value[next.v] > value[now.v] + next.c) {
                    value[next.v] = value[now.v] + next.c;
                    pq.add(new Edge(next.v, value[next.v]));
                }
            }
        }

        return result;
    }

    static class Edge implements Comparable<Edge>{
        int v, c;

        Edge(int v, int c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(Edge o) {
            return this.c - o.c;
        }
    }
}
