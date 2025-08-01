import java.io.*;
import java.util.*;

public class Main {
    static int n, e, INF = 200000000;
    static List<Node>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v, c));
            list[v].add(new Node(u, c));
        }

        st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        int a = dijkstra(1, n1);
        int b = dijkstra(n1, n2);
        int c = dijkstra(n2, n);
        int sum1 = a + b + c;

        a = dijkstra(1, n2);
        b = dijkstra(n2, n1);
        c = dijkstra(n1, n);
        int sum2 = a + b + c;



        System.out.print((sum1 >= INF && sum2 >= INF) ? -1 : Math.min(sum1, sum2));
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n+1];
        int[] val = new int[n+1];
        Arrays.fill(val, INF);
        val[start] = 0;

        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node pos = pq.poll();

            if(visited[pos.v]) continue;

            visited[pos.v] = true;

            if(pos.v == end) break;

            for(Node next : list[pos.v]) {
                if(visited[next.v]) continue;
                if(val[next.v] <= val[pos.v] + next.c) continue;

                val[next.v] = val[pos.v] + next.c;
                pq.add(new Node(next.v, val[pos.v] + next.c));
            }
        }

        return val[end];
    }

    static class Node implements Comparable<Node>{
        int v, c;

        Node(int v, int c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(Node o) {
            return this.c - o.c;
        }
    }
}
