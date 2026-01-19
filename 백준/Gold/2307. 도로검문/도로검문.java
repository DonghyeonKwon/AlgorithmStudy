import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] prev;
    static List<Edge>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        prev = new int[n+1];

        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[u].add(new Edge(v, c, i));
            list[v].add(new Edge(u, c, i));
        }

        int min = dijkstra(-1);
        int res = -1;

        List<Integer> list = new ArrayList<>();
        int p = prev[n];
        while(p != 1) {
            list.add(p);
            p = prev[p];
        }

        for(int pp : list) {
            int k = dijkstra(pp);
            if(k == -1) {
                res = -1;
                break;
            }

            res = Math.max(res, k - min);
        }

        System.out.print(res);
    }

    static int dijkstra(int idx) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(
                (x, y) -> x.c - y.c
        );

        int[] values = new int[n+1];
        Arrays.fill(values, Integer.MAX_VALUE);

        values[1] = 0;
        pq.add(new Edge(1, 0, 0));

        while(!pq.isEmpty()) {
            Edge now = pq.poll();

            if(now.v == n) {
                return now.c;
            }

            if(values[now.v] < now.c) continue;

            for(Edge next : list[now.v]) {
                if(next.v == idx) continue;
                if(values[next.v] > now.c + next.c) {
                    prev[next.v] = now.v;
                    values[next.v] = now.c + next.c;
                    pq.add(new Edge(next.v, values[next.v], 0));
                }
            }
        }

        return -1;
    }

    static class Edge {
        int v, c, idx;

        Edge(int v, int c, int idx) {
            this.v = v;
            this.c = c;
            this.idx = idx;
        }
    }
}
