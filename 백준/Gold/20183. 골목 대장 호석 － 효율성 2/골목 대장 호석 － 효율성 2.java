import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static long[] values;
    static List<Edge>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        list = new ArrayList[n+1];
        values = new long[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        long maxC = 0;
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            list[u].add(new Edge(v, c));
            list[v].add(new Edge(u, c));
            maxC = Math.max(maxC, c);
        }

        if(!dijkstra(a, b, C, maxC)) {
            System.out.print(-1);
            return;
        }

        values = new long[n+1];
        long l = 0;
        long r = maxC;
        long ans = maxC;
        while(l <= r) {
            long mid = (l + r) / 2;

            if(dijkstra(a, b, C, mid)) {
                ans = mid;
                r = ans - 1;
            } else {
                l = mid + 1;
            }
        }

        System.out.print(ans);
    }

    static boolean dijkstra(int a, int b, long C, long mid) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Arrays.fill(values, Long.MAX_VALUE);
        values[a] = 0;
        pq.add(new Edge(a, 0));

        while(!pq.isEmpty()) {
            Edge pos = pq.poll();
            int now = pos.v;

            if(pos.c != values[now]) continue;

            if(now == b) {
                return true;
            }

            for(Edge next : list[now]) {
                if(next.c <= mid && values[now] + next.c <= C && values[next.v] > values[now] + next.c) {
                    values[next.v] = values[now] + next.c;
                    Edge nPos = new Edge(next.v, values[next.v]);
                    pq.add(nPos);
                }
            }
        }

        return false;
    }

    static class Edge implements Comparable<Edge>{
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
