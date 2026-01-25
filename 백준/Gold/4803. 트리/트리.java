import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int idx = 1;

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0) break;

            init();

            visited = new boolean[n+1];
            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }

            Set<Integer> set = new HashSet<>();
            for(int i = 1; i <= n; i++) {
                int r = find(i);
                if(!visited[r]) set.add(r);
            }

            sb.append("Case ").append(idx++).append(": ");
            if(set.isEmpty()) {
                sb.append("No trees.\n");
            } else if(set.size() == 1) {
                sb.append("There is one tree.\n");
            } else {
                sb.append("A forest of ").append(set.size()).append(" trees.\n");
            }
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

        if(aa == bb) {
            visited[aa] = true;
            return;
        }

        if(aa > bb) {
            int tmp = bb;
            bb = aa;
            aa = tmp;
        }

        if(visited[bb] || visited[aa]) {
            visited[bb] = true;
            visited[aa] = true;
        }

        parent[bb] = aa;
       
        visited[aa] = visited[aa] || visited[bb];
    }

    static void init() {
        parent = new int[n+1];

        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }
}
