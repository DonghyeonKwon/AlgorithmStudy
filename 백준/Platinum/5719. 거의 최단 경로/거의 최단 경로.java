import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] dp;
    static boolean[][] check;
    static List<Integer>[] parent;
    static List<Info>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0) break;

            dp = new int[n];
            list = new ArrayList[n];
            parent = new ArrayList[n];
            check = new boolean[n][n];
            for(int i = 0; i < n; i++) {
                list[i] = new ArrayList<>();
                parent[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                list[from].add(new Info(to, cost));
            }

            dijkstra(s, d);
            backTracking(s, d);
            dijkstra(s, d);

            if(dp[d] == Integer.MAX_VALUE) {
                sb.append("-1\n");
            } else {
                sb.append(dp[d]+"\n");
            }
        }

        System.out.print(sb);
    }

    static void backTracking(int s, int node) {
        if(node == s) return;

        for(int prev : parent[node]) {
            if(!check[prev][node]) {
                check[prev][node] = true;
                backTracking(s, prev);
            }
        }
    }

    static void dijkstra(int s, int d) {
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[s] = 0;
        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.add(new Info(s, dp[s]));

        while(!pq.isEmpty()) {
            Info now = pq.poll();

            if(dp[now.v] < now.c) continue;

            for(Info next : list[now.v]) {
                if(!check[now.v][next.v]) {
                    if(dp[next.v] == dp[now.v] + next.c) {
                        parent[next.v].add(now.v);
                    } else if (dp[next.v] > dp[now.v] + next.c) {
                        dp[next.v] = dp[now.v] + next.c;
                        parent[next.v].clear();
                        parent[next.v].add(now.v);
                        pq.add(new Info(next.v, dp[next.v]));
                    }
                }
            }
        }
    }

    static class Info implements Comparable<Info> {
        int v, c;

        Info(int v, int c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(Info o) {
            return this.c - o.c;
        }
    }
}
