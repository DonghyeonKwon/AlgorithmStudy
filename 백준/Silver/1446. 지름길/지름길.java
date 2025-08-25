import java.io.*;
import java.util.*;

public class Main {
    static int n, d;
    static List<Edge>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        list = new ArrayList[d+1];
        for(int i = 0; i <= d; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(u > d || v > d || c > d) continue;
            list[u].add(new Edge(v, c));
        }

        int[] value = new int[d+1];
        Arrays.fill(value, 100000000);
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0));
        value[0] = 0;

        while(!pq.isEmpty()) {
            Edge pos = pq.poll();

            if(pos.v == d) continue;

            for(Edge next : list[pos.v]) {
                if(next.v <= d && value[next.v] > pos.c + next.c) {
                    value[next.v] = pos.c + next.c;
                    pq.add(new Edge(next.v, value[next.v]));
                }
            }

            int nv = pos.v + 1;
            int nc = pos.c + 1;
            if(nv <= d && value[nv] > nc) {
                value[nv] = nc;
                pq.add(new Edge(nv, nc));
            }
        }

        System.out.print(value[d]);
    }

    static class Edge implements Comparable<Edge>{
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
