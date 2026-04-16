import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] parent;
    static Circle[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            n = Integer.parseInt(br.readLine());
            init();

            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                arr[i] = new Circle(x, y, r);
            }

            for(int i = 0; i < n-1; i++) {
                for(int j = i + 1; j < n; j++) {
                    if(check(i, j)) {
                        union(i, j);
                    }
                }
            }

            int cnt = 0;
            for(int i = 0; i < n; i++) {
                if(i == parent[i]) cnt++;
            }
            sb.append(cnt).append('\n');
        }

        System.out.print(sb);
    }

    static void init() {
        parent = new int[n];
        arr = new Circle[n];

        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    static double pow(double a) {
        return a * a;
    }

    static boolean check(int i, int j) {
        double r = pow(arr[i].r + arr[j].r);
        double p = pow(arr[i].x - arr[j].x) + pow(arr[i].y - arr[j].y);

        return p <= r;
    }

    static int find(int x) {
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int aa = find(a);
        int bb = find(b);

        if(aa == bb) return;

        if(aa > bb) {
            int tmp = aa;
            aa = bb;
            bb = tmp;
        }

        parent[bb] = aa;
    }

    static class Circle {
        int x, y;
        double r;

        Circle(int x, int y, double r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }
}
