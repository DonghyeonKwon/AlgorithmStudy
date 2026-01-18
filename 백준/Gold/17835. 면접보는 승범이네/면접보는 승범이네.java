import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Edge>[] list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[v].add(new Edge(u, c));
        }

        st = new StringTokenizer(br.readLine());
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        long[] values = new long[n+1];
        boolean[] visited = new boolean[n+1];
        Arrays.fill(values, Long.MAX_VALUE);

        for(int i = 0; i < k; i++) {
            int p = Integer.parseInt(st.nextToken());
            pq.add(new Edge(p, 0));
            values[p] = 0;
        }

        while(!pq.isEmpty()) {
            Edge now = pq.poll();

            if(visited[now.v]) continue;
            visited[now.v] = true;

            for(Edge next : list[now.v]) {
                if(values[next.v] > now.c + next.c) {
                    values[next.v] = now.c + next.c;
                    pq.add(new Edge(next.v, values[next.v]));
                }
            }
        }

        int idx = 0;
        long max = -1;
        for(int i = 1; i <= n; i++) {
            if(max < values[i]) {
                idx = i;
                max = values[i];
            }
        }

        System.out.println(idx);
        System.out.println(max);
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
