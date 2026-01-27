import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static int[] money;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        money = new int[n+1];
        parent = new int[n+1];
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            money[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            union(v, w);
        }

        Set<Integer> set = new HashSet<>();
        for(int i = 1; i <= n; i++) {
            int p = find(i);
            set.add(p);
        }

        int sum = 0;
        for(int p : set) {
            sum += money[p];
        }

        if(sum > k) {
            System.out.println("Oh no");
        } else {
            System.out.println(sum);
        }
    }

    static int find(int x) {
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int v, int w) {
        int vv = find(v);
        int ww = find(w);

        if(vv == ww) return;

        if(money[vv] > money[ww]) {
            parent[vv] = ww;
        } else {
            parent[ww] = vv;
        }
    }
}
