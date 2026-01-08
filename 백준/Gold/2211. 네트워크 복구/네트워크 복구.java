import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<Edge>[] list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
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
        dijkstra();

        System.out.println(n-1);
        System.out.print(sb);
    }

    static void dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n+1];
        int[] value = new int[n+1];
        Arrays.fill(value, Integer.MAX_VALUE);
        value[1] = 0;
        visited[1] = true;
        int cnt = 1;

        for(Edge next : list[1]) {
            if(value[next.v] > next.c) {
                value[next.v] = next.c;
                pq.add(new Edge(next.v, value[next.v], 1));
            }
        }

        while(!pq.isEmpty()) {
            Edge now = pq.poll();

            if(visited[now.v]) continue;
            cnt++;
            sb.append(now.prev).append(' ').append(now.v).append('\n');
            visited[now.v] = true;

            if(cnt == n) break;
            for(Edge next : list[now.v]) {
                if(value[next.v] > next.c + now.c) {
                    value[next.v] = next.c + now.c;
                            pq.add(new Edge(next.v, value[next.v], now.v));
                }
            }
        }
    }

    static class Edge implements Comparable<Edge> {
        int v, c;
        int prev;

        Edge(int v, int c) {
            this.v = v;
            this.c = c;
        }

        Edge(int v, int c, int prev) {
            this.v = v;
            this.c = c;
            this.prev = prev;
        }

        @Override
        public int compareTo(Edge o) {
            return this.c - o.c;
        }
    }
}
