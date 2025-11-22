import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][2];
        parent = new int[n+1];
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = y;
            parent[i] = i;
        }

        double result = 0;
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        List<Edge> list = new ArrayList<>();
        for(int i = 1; i < n; i++) {
            for(int j = i+1; j <= n; j++) {
                double len = Math.sqrt(Math.pow(arr[i][0] - arr[j][0], 2) + Math.pow(arr[i][1] - arr[j][1], 2));
                list.add(new Edge(i, j, len));
            }
        }

        Collections.sort(list);

        for(Edge edge : list) {
            if(check()) break;

            if(find(edge.a) == find(edge.b)) continue;
            result += edge.len;
            m++;
            union(edge.a, edge.b);
        }

        System.out.printf("%.2f", result);
    }

    static boolean check() {
        for(int i = 1; i <= n; i++) {
            if(find(i) != 1) return false;
        }
        return true;
    }

    static int find(int x) {
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int aP = find(a);
        int bP = find(b);

        if(aP > bP) parent[aP] = bP;
        else parent[bP] = aP;
    }

    static class Edge implements Comparable<Edge> {
        int a, b;
        double len;

        Edge(int a, int b, double len) {
            this.a = a;
            this.b = b;
            this.len = len;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.len, o.len);
        }
    }
}
