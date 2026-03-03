import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int m = Integer.parseInt(br.readLine());

        while(m-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            pq.add(new Edge(a, b, val));
        }

        int cnt = 1;
        int sum = 0;
        while(!pq.isEmpty() && cnt < n) {
            Edge e = pq.poll();

            if(union(e.a, e.b)) {
                sum += e.val;
            }
        }

        System.out.print(sum);
    }

    static int find(int x) {
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b) {
        int aa = find(a);
        int bb = find(b);

        if(aa == bb) return false;

        if(aa > bb) {
            int tmp = aa;
            aa = bb;
            bb= tmp;
        }

        parent[bb] = aa;

        return true;
    }

    static class Edge implements Comparable<Edge> {
        int a, b, val;

        Edge(int a, int b, int val) {
            this.a = a;
            this.b = b;
            this.val = val;
        }

        @Override
        public int compareTo(Edge o) {
            return this.val - o.val;
        }
    }
}
