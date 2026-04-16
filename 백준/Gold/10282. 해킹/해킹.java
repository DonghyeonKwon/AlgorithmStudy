import java.io.*;
import java.util.*;

public class Main {

    static int n, m, c, cnt;
    static List<Node>[] list;
    static int[] val;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            list = new ArrayList[n+1];
            val = new int[n+1];
            cnt = 0;
            for(int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
                val[i] = 1_000_000_000;
            }

            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                list[v].add(new Node(u, c));
            }

            int time = dijkstra();

            bw.write(cnt + " " + time + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[n+1];
        pq.add(new Node(c, 0));
        val[c] = 0;
        int time = 0;

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(visited[now.v]) continue;

            visited[now.v] = true;
            time = now.c;
            cnt++;

            for(Node next : list[now.v]) {
                if(!visited[next.v] && val[next.v] > val[now.v] + next.c) {
                    val[next.v] = val[now.v] + next.c;
                    pq.add(new Node(next.v, val[next.v]));
                }
            }
        }

        return time;
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
