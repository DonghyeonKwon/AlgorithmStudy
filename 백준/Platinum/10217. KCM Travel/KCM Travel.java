import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static int[][] dp;
    static List<Pos>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            list = new ArrayList[n+1];
            dp = new int[n+1][m+1];

            for(int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }

            for(int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                list[u].add(new Pos(v, c, d));
            }

            go();

            int min = Integer.MAX_VALUE;
            for(int i = 0; i <= m; i++){
                min = Math.min(dp[n][i], min);
            }

            if(min == Integer.MAX_VALUE) {
                bw.write("Poor KCM");
            } else {
                bw.write(Integer.toString(min));
            }
            bw.write('\n');
        }

        bw.flush();

        bw.close();
        br.close();
    }

    static void go() {
        for(int i = 1; i <= n; i++){
            Collections.sort(list[i]);
        }

        PriorityQueue<Pos> pq = new PriorityQueue<>();
        pq.add(new Pos(1, 0, 0));
        dp[1][0] = 0;

        while(!pq.isEmpty()) {
            Pos p = pq.poll();

            if(p.v == n) {
                return;
            }

            for(Pos next : list[p.v]) {
                int nextNode = next.v;
                int nextCost = p.c + next.c;
                int nextTime = p.d + next.d;

                if(nextCost > m) continue;
                if(dp[nextNode][nextCost] > nextTime) {
                    for(int i = nextCost; i <= m; i++) {
                        if(dp[nextNode][i] <= nextTime) break;
                        dp[nextNode][i] = nextTime;
                    }

                    pq.add(new Pos(nextNode, nextCost, nextTime));
                }
            }
        }

    }

    static class Pos implements Comparable<Pos>{
        int v, c, d;

        Pos(int v, int c, int d) {
            this.v = v;
            this.c = c;
            this.d = d;
        }

        @Override
        public int compareTo(Pos o) {
            if(this.d == o.d) {
                return this.c - o.c;
            }
            return this.d - o.d;
        }
    }
}
