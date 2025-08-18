import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<Integer>[] F, E;
    static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        F = new ArrayList[n+1];
        E = new ArrayList[n+1];
        parents = new int[n+1];
        for(int i = 1; i <= n; i++) {
            F[i] = new ArrayList<>();
            E[i] = new ArrayList<>();
            parents[i] = i;
        }

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            if(c == 'F') {
                F[p].add(q);
                F[q].add(p);
            } else {
                E[p].add(q);
                E[q].add(p);
            }
        }

        for(int k = 1; k <= n; k++) {
            for(int i : E[k]) {
                for(int j : E[i]) {
                    if(k == j) continue;
                    F[k].add(j);
                    F[j].add(k);
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j : F[i]) {
                union(i, j);
            }
        }

        int cnt = 0;
        for(int i = 1; i <= n; i++) {
            if(parents[i] == i) cnt++;
        }

        System.out.print(cnt);
    }

    static int find(int a) {
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    static void union(int i, int j) {
        int p1 = find(i);
        int p2 = find(j);

        if(p1 != p2) {
            parents[p2] = p1;
        }
    }

}
