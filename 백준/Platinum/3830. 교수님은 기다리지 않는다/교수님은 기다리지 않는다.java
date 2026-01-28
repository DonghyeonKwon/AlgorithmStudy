import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] parent;
    static int[] rank;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0) break;

            init();

            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                char c = st.nextToken().charAt(0);
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(c == '!') {
                    int w = Integer.parseInt(st.nextToken());

                    union(a, b, w);
                } else {
                    if(find(a) != find(b)) {
                        sb.append("UNKNOWN\n");
                    } else {
                        sb.append((rank[b] - rank[a]) + "\n");
                    }
                }
            }
        }

        System.out.print(sb);
    }

    static void init() {
        parent = new int[n+1];
        rank = new int[n+1];

        for(int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    static int find(int x) {
        if(x == parent[x]) return x;
        int xx = find(parent[x]);
        rank[x] += rank[parent[x]];
        return parent[x] = xx;
    }

    static void union(int a, int b, int w) {
        int aa = find(a);
        int bb = find(b);

        if(aa == bb) return;
        rank[bb] = rank[a] - rank[b] + w;
        parent[bb] = aa;
    }
}
