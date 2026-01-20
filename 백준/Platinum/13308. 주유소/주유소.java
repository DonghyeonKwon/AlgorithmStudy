import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<Info>[] list;
    static int[] fuels;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        fuels = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            fuels[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[u].add(new Info(v, c, 0));
            list[v].add(new Info(u, c, 0));
        }

        System.out.print(dijkstra());
    }

    static long dijkstra() {
        PriorityQueue<Info> pq = new PriorityQueue<>(
                (x, y) -> Long.compare(x.c, y.c)
        );
        long[][] values = new long[n+1][2501];
        for(int i = 1; i <= n; i++) Arrays.fill(values[i], Long.MAX_VALUE);
        pq.add(new Info(1, 0, fuels[1]));
        values[1][fuels[1]] = 0;
        long min = Long.MAX_VALUE;

        while(!pq.isEmpty()) {
            Info now = pq.poll();

            if(values[now.v][now.fuel] < now.c) continue;

            if(now.v == n) {
                return now.c;
            }

            for(Info next : list[now.v]) {
                int nextFuel = Math.min(now.fuel, fuels[next.v]);
                long nextCost = now.c + next.c * now.fuel;

                if(values[next.v][now.fuel] > nextCost) {
                    values[next.v][now.fuel] = nextCost;
                    pq.add(new Info(next.v, nextCost, nextFuel));
                }
            }
        }

        return min;
    }

    static class Info {
        int v;
        long c;
        int fuel;

        Info(int v, long c, int fuel) {
            this.v = v;
            this.c = c;
            this.fuel = fuel;
        }
    }
}
