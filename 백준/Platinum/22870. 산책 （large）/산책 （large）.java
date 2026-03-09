import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static long[] distS;
    static long[] distE;
    static List<Edge>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        visited = new boolean[n+1];
        distS = new long[n+1];
        distE = new long[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            distS[i] = distE[i] = Long.MAX_VALUE;
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Edge(b, c));
            list[b].add(new Edge(a, c));
        }


        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        dijkstra(distS, s);
        dijkstra(distE, e);
        long ans = distS[e];

        erase(s, e);
        Arrays.fill(distE, Long.MAX_VALUE);
        dijkstra(distE, e);

        ans += distE[s];

        System.out.print(ans);
    }

    static void erase(int s, int e) {
        int start = s, pre = s;

        while(start != e) {
            int min = 500000;
            for(Edge next : list[start]) {
                if(pre == next.v) continue;
                if(distS[start] + next.c + distE[next.v] == distS[e]) {
                    min = Math.min(min, next.v);
                }
            }

            pre = start;
            start = min;
            if(start != e) visited[start] = true;
        }
    }

    static void dijkstra(long[] dist, int s) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(s, 0));
        dist[s] = 0;

        while(!pq.isEmpty()) {
            Edge pos = pq.poll();

            if(dist[pos.v] < pos.c) continue;

            for(Edge next : list[pos.v]) {
                if(!visited[next.v] && dist[next.v] > pos.c + next.c) {
                    dist[next.v] = pos.c + next.c;
                    pq.add(new Edge(next.v, dist[next.v]));
                }
            }
        }
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
