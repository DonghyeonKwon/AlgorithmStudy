import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static List<Edge>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[u].add(new Edge(v, c, 0));
            list[v].add(new Edge(u, c, 0));
        }

        long res = dijkstra();

        System.out.print(res);
    }

    static long dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        long[][] value = new long[k+1][n+1];
        for(int i = 0; i <= k; i++) {
            Arrays.fill(value[i], Long.MAX_VALUE);
        }
        pq.add(new Edge(1, 0, 0));
        value[0][1] = 0;

        while(!pq.isEmpty()) {
            Edge now = pq.poll();

            if(value[now.k][now.v] < now.c) {
                continue;
            }

            for(Edge next : list[now.v]) {
                if(value[now.k][next.v] > (now.c + next.c)) {
                    value[now.k][next.v] = next.c + now.c;
                    pq.add(new Edge(next.v, value[now.k][next.v], now.k));
                }

                if(now.k < k && value[now.k + 1][next.v] > now.c) {
                    value[now.k + 1][next.v] = now.c;
                    pq.add(new Edge(next.v, now.c, now.k + 1));
                }
            }
        }

        long result = Long.MAX_VALUE;
        for(int i = 0; i <= k; i++) {
            result = Math.min(result, value[i][n]);
        }

        return result;
    }

    static class Edge implements Comparable<Edge> {
        int v, k;
        long c;

        Edge(int v, long c, int k) {
            this.v = v;
            this.c = c;
            this.k = k;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.c, o.c);
        }
    }
}
