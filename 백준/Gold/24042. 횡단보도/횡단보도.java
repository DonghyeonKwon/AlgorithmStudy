import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Node>[] list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list[s].add(new Node(e, i));
            list[e].add(new Node(s, i));
        }

        long[] value = new long[n+1];
        Arrays.fill(value, Long.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        value[1] = 0;
        pq.add(new Node(1, 0));

        while(!pq.isEmpty()) {
            Node pos = pq.poll();

            if(pos.c > value[pos.v]) continue;

            for(Node next : list[pos.v]) {

                long nextCost;
                if(pos.c <= next.c) {
                    nextCost = next.c + 1;
                } else {
                    nextCost = ((long) Math.ceil(((double)pos.c - next.c)/m)) * m + next.c + 1;
                }

                if(nextCost < value[next.v]) {
                    value[next.v] = nextCost;
                    pq.add(new Node(next.v, nextCost));
                }
            }
        }

        System.out.print(value[n]);
    }

    static class Node implements Comparable<Node>{
        int v;
        long c;

        Node(int v, long c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.c, o.c);
        }
    }

}
