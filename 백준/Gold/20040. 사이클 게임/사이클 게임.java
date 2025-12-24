import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for(int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(union(a, b)) {
                System.out.print(i);
                return;
            }
        }

        System.out.print(0);
    }

    static int find(int x) {
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b) {
        int aa = find(a);
        int bb = find(b);

        if(aa == bb) return true;

        if(aa > bb) {
            parent[aa] = bb;
        } else {
            parent[bb] = aa;
        }

        return false;
    }
}
