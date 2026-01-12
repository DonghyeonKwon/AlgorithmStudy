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

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Edge(b, c));
            list[b].add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        System.out.print(dijkstra(s, t));
    }

    static int dijkstra(int s, int t) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n+1];
        int[] values = new int[n+1];
        Arrays.fill(values, 1_000_000_000);
        values[s] = 0;
        pq.add(new Edge(s, 0));


        while(!pq.isEmpty()) {
            Edge now = pq.poll();

            visited[now.v] = true;
            if(now.v == t) {
                return now.c;
            }

            for(Edge next : list[now.v]) {
                if(visited[next.v]) continue;
                if(values[next.v] < now.c + next.c) continue;
                values[next.v] = now.c + next.c;
                pq.add(new Edge(next.v, values[next.v]));
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
