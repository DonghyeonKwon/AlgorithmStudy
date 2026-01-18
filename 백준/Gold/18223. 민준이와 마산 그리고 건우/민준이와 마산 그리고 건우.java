import java.io.*;
import java.util.*;

public class Main {
    static int n, m, p;
    static List<Edge>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

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

        int res = dijkstra(1, n);
        int res2 = dijkstra(1, p) + dijkstra(p, n);

        if(res >= res2) {
            System.out.print("SAVE HIM");
        } else {
            System.out.print("GOOD BYE");
        }
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n+1];
        int[] values = new int[n+1];
        Arrays.fill(values, Integer.MAX_VALUE);
        pq.add(new Edge(start, 0));
        values[start] = 0;

        while(!pq.isEmpty()) {
            Edge now = pq.poll();

            if(visited[now.v]) continue;
            visited[now.v] = true;

            if(now.v == end) {
                return now.c;
            }

            for(Edge next : list[now.v]) {
                if(values[next.v] > now.c + next.c) {
                    values[next.v] = now.c + next.c;
                    pq.add(new Edge(next.v, values[next.v]));
                }
            }
        }

        return -1;
    }

    static class Edge implements Comparable<Edge> {
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
