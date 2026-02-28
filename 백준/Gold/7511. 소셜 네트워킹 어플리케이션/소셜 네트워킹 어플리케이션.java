import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        for(int T = 1; T <= t; T++) {
            n = Integer.parseInt(br.readLine());
            parent = new int[n];
            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }

            int k = Integer.parseInt(br.readLine());
            for(int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            }
            sb.append("Scenario ").append(T).append(":\n");
            k = Integer.parseInt(br.readLine());
            for(int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                a = find(a);
                b = find(b);
                if(a == b) {
                    sb.append(1).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            }
            if(T != t) sb.append('\n');
        }

        System.out.print(sb);
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
            int temp = aa;
            aa = bb;
            bb = temp;
        }

        parent[bb] = aa;
    }
}
