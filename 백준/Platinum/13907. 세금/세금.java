import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static int[] taxes;
    static int[][] res;
    static List<Edge>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

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

        taxes = new int[k+1];
        for(int i = 1; i <= k; i++) {
            taxes[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        dijkstra(s, d);

        for(int i = 0; i <= k; i++) {
            int curTax = taxes[i];
            int max = Integer.MAX_VALUE;

            for(int j = 1; j <= n; j++) {
                if(res[d][j] == Integer.MAX_VALUE) continue;

                int upper = (j-1) * curTax;
                res[d][j] += upper;

                max = Math.min(max, res[d][j]);
            }

            sb.append(max).append('\n');
        }

        System.out.print(sb);
    }

    static void dijkstra(int s, int d) {
        res = new int[n+1][n+2];
        PriorityQueue<Edge> pq = new PriorityQueue<>(
                (x, y) -> x.c - y.c
        );

        for(int i = 0; i <= n; i++) {
            Arrays.fill(res[i], Integer.MAX_VALUE);
        }
        for(int i = 0; i <= n+1; i++) {
            res[s][i] = 0;
        }
        pq.add(new Edge(s, 0, 1));

        while(!pq.isEmpty()) {
            Edge now = pq.poll();

            if(now.v == d)
                continue;

            if(res[now.v][now.cnt] < now.c) continue;

            for(Edge next : list[now.v]) {
                int nextC = now.c + next.c;
                int nextCnt = now.cnt + 1;

                if(res[next.v][nextCnt] > nextC) {
                    res[next.v][nextCnt] = nextC;
                    pq.add(new Edge(next.v, nextC, nextCnt));
                }

                for(int tmpC = nextCnt + 1; tmpC <= n; tmpC++) {
                    if(res[next.v][tmpC] > nextC) {
                        res[next.v][tmpC] = nextC;
                    }
                }
            }
        }

    }

    static class Edge {
        int v, c, cnt;

        Edge(int v, int c, int cnt) {
            this.v = v;
            this.c = c;
            this.cnt = cnt;
        }
    }
}
