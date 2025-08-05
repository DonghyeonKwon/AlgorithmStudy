import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static List<Node>[] list;
    static int[] val;
    static int[] come;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        int m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v, c));
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        dijkstra(s, e);

        System.out.println(val[e]);
        List<Integer> answer = new ArrayList<>();
        int pos = e;
        while(pos != 0) {
            answer.add(pos);
            pos = come[pos];
        }
        System.out.println(answer.size());
        Collections.reverse(answer);
        for(int i : answer) {
            System.out.print(i + " ");
        }
    }

    static void dijkstra(int s, int e) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        val = new int[n+1];
        come = new int[n+1];
        Arrays.fill(val, Integer.MAX_VALUE);

        boolean[] visited = new boolean[n+1];
        pq.add(new Node(s, 0));
        val[s] = 0;
        come[s] = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(visited[now.v]) continue;
            visited[now.v] = true;
            if(now.v == e) break;

            for(Node next : list[now.v]) {
                if(visited[next.v]) continue;
                if(val[next.v] < val[now.v] + next.c) continue;

                val[next.v] = val[now.v] + next.c;
                come[next.v] = now.v;
                pq.add(new Node(next.v, val[next.v]));
            }
        }

    }

    static class Node implements Comparable<Node> {
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
