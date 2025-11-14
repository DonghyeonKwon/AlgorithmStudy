import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<Integer>[] list;
    static Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

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

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(map.containsKey(u) && map.get(u).containsKey(v)) {
                map.get(u).put(v, Math.max(map.get(u).get(v), c));
                map.get(v).put(u, Math.max(map.get(v).get(u), c));
            } else {
                list[u].add(v);
                list[v].add(u);

                if(!map.containsKey(u)) {
                    map.put(u, new HashMap<>());
                }
                if(!map.containsKey(v)) {
                    map.put(v, new HashMap<>());
                }

                map.get(u).put(v, c);
                map.get(v).put(u, c);
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int ans = search(start, end);
        System.out.print(ans);
    }

    static int search(int start, int end) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n+1];
        pq.add(new Edge(start, Integer.MAX_VALUE));

        while(!pq.isEmpty()) {
            Edge now = pq.poll();
            if(now.v == end) {
                return now.c;
            }

            if(visited[now.v]) continue;
            visited[now.v] = true;

            for(Integer next : list[now.v]) {
                if(!visited[next]) {
                    pq.add(new Edge(next, Math.min(now.c, map.get(now.v).get(next))));
                }
            }
        }

        return 0;
    }

    static class Edge implements Comparable<Edge> {
        int v, c;

        Edge(int v, int c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(Edge o) {
            return o.c - this.c;
        }
    }
}
