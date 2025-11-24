import java.io.*;
import java.util.*;

public class Main {
    static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        parents = new int[n];
        double[][] stars = new double[n][2];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            stars[i][0] = Double.parseDouble(st.nextToken());
            stars[i][1] = Double.parseDouble(st.nextToken());
            parents[i] = i;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                pq.add(new Edge(i, j, Math.sqrt(Math.pow(stars[i][0] - stars[j][0], 2) + Math.pow(stars[i][1] - stars[j][1], 2))));
            }
        }

        int m = 0;
        double res = 0.0;
        while(!pq.isEmpty()) {
            Edge now = pq.poll();
            if(m == n-1) break;
            if(union(now.a, now.b)) {
                res += now.dis;
                m++;
            }
        }

        System.out.printf("%.2f", res);
    }

    static int find(int x) {
        if(parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    static boolean union(int a, int b) {
        int aa = find(a);
        int bb = find(b);

        if(aa == bb) return false;

        if(aa < bb) {
            parents[bb] = aa;
        } else {
            parents[aa] = bb;
        }

        return true;
    }

    static class Edge implements Comparable<Edge> {
        int a, b;
        double dis;

        Edge(int a, int b, double dis) {
            this.a = a;
            this.b = b;
            this.dis = dis;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.dis, o.dis);
        }
    }
}
