import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static List<Edge>[] list;
    static Queue<Integer>[] dis;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        dis = new PriorityQueue[n+1];

        for(int i = 1; i <= n; i++) {
            dis[i] = new PriorityQueue<>(Collections.reverseOrder());
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[u].add(new Edge(v, c));
        }

        dijkstra(1);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            if(dis[i].size() == k) sb.append(dis[i].peek()).append('\n');
            else sb.append(-1).append('\n');
        }

        System.out.print(sb);
    }

    static int dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        dis[start].add(0);

        while(!pq.isEmpty()) {
            Edge now = pq.poll();
            int to = now.v;
            int weight = now.c;

            for(Edge next : list[to]) {
                if(dis[next.v].size() < k) {
                    dis[next.v].add(weight + next.c);
                    pq.add(new Edge(next.v, weight + next.c));
                } else if(dis[next.v].peek() > weight + next.c) {
                    dis[next.v].poll();
                    dis[next.v].add(weight + next.c);
                    pq.add(new Edge(next.v, weight + next.c));
                }
            }
        }

        return -1;
    }

    static class Edge implements Comparable<Edge> {
        int v, c, cnt;

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
