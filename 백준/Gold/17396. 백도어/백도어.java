import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static boolean[] canGo;
    static List<Edge>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        canGo = new boolean[n];
        for(int i = 0; i < n; i++) {
            canGo[i] = Integer.parseInt(st.nextToken()) == 0;
        }
        canGo[n-1] = true;

        list = new ArrayList[n];
        for(int i = 0; i < n; i++) {
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

    static long dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n];
        long[] values = new long[n];

        Arrays.fill(values, Long.MAX_VALUE);
        pq.add(new Edge(0, 0));
        values[0] = 0;

        while(!pq.isEmpty()) {
            Edge now = pq.poll();

            if(visited[now.v]) continue;
            visited[now.v] = true;
            if(now.v == n - 1) {
                return now.c;
            }

            for(Edge next : list[now.v]) {
                if(!canGo[next.v]) continue;
                if(values[next.v] > now.c + next.c) {
                    values[next.v] = now.c + next.c;
                    pq.add(new Edge(next.v, values[next.v]));
                }
            }

        }

        return -1;
    }

    static class Edge implements Comparable<Edge> {
        int v;
        long c;

        Edge(int v, long c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.c, o.c);
        }
    }
}
