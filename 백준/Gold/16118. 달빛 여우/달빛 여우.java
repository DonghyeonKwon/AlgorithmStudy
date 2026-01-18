import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<Edge>[] list;

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

        double[][] wolf = wolfDijkstra(1);
        double[] fox = foxDijkstra(1);

        int cnt = 0;
        for(int i = 1; i <= n; i++) {
            if(fox[i] < Math.min(wolf[0][i], wolf[1][i])) {
                cnt++;
            }
        }

        System.out.print(cnt);
    }

    static double[] foxDijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        double[] values = new double[n+1];
        Arrays.fill(values, Double.MAX_VALUE);

        pq.add(new Edge(start, 0));
        values[start] = 0;

        while(!pq.isEmpty()) {
            Edge now = pq.poll();
            
            if(values[now.v] < now.c) continue;

            for(Edge next : list[now.v]) {
                if(values[next.v] > now.c + next.c) {
                    values[next.v] = now.c + next.c;
                    pq.add(new Edge(next.v, values[next.v]));
                }

            }
        }

        return values;
    }

    static double[][] wolfDijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        double[][] values = new double[2][n+1];

        Arrays.fill(values[0], Double.MAX_VALUE);
        Arrays.fill(values[1], Double.MAX_VALUE);

        pq.add(new Edge(start, 0));
        values[0][start] = 0;

        while(!pq.isEmpty()) {
            Edge now = pq.poll();

            if(values[now.cnt][now.v] < now.c) continue;


            for(Edge next : list[now.v]) {
                int nextCnt = 1 - now.cnt;
                double nextCost;

                if(now.cnt == 0) {
                    nextCost = next.c / 2;
                } else {
                    nextCost = next.c * 2;
                }

                nextCost += now.c;

                if(values[nextCnt][next.v] > nextCost) {
                    values[nextCnt][next.v] = nextCost;
                    Edge nEdge = new Edge(next.v, nextCost);
                    nEdge.cnt = nextCnt;
                    pq.add(nEdge);
                }
            }
        }

        return values;
    }

    static class Edge implements Comparable<Edge> {
        int v, cnt = 0;
        double c;

        Edge(int v, double c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.c, o.c);
        }
    }
}
