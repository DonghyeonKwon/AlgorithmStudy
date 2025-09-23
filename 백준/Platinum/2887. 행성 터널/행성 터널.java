import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        parent = new int[n];
        List<int[]> data = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            data.add(new int[]{i, x, y, z});
            parent[i] = i;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int idx = 1; idx <= 3; idx++) {
            int v = idx;
            Collections.sort(data, (o1, o2) -> o1[v] - o2[v]);

            for(int i = 1; i < n; i++) {
                int[] p1 = data.get(i-1);
                int[] p2 = data.get(i);
                int dis = Math.abs(p1[idx] - p2[idx]);

                pq.add(new Node(p1[0], p2[0], dis));
            }
        }

        int total = 0;
        while(!pq.isEmpty()) {
            Node node = pq.poll();

            int rx = find(node.to);
            int ry = find(node.from);

            if(rx != ry) {
                total += node.value;
                union(node.to, node.from);
            }
        }

        System.out.print(total);
    }

    static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int l, int r) {
        int pl = find(l);
        int pr = find(r);

        if(pl < pr) {
            int tmp = pl;
            pl = pr;
            pr = tmp;
        }

        parent[pr] = pl;
    }

    static class Node implements Comparable<Node> {
        int to, from, value;

        Node(int to, int from, int value) {
            this.to = to;
            this.from = from;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
}
