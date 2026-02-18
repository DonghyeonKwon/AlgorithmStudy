import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int[] power;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        power = new int[n+1];
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
            power[i] = 1;
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        st = new StringTokenizer(br.readLine());

        int c = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        c = find(c);
        h = find(h);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> b[2] - a[2]
        );
        for(int i = 1; i <= n; i++) {
            if(c != parent[i] && h != parent[i]) {
                pq.add(new int[]{c, parent[i], power[parent[i]]});
            }
        }

        while(k > 0 && !pq.isEmpty()) {
            int[] arr = pq.poll();
            if(union(arr[0], arr[1])) {
                k--;
            }
        }

        System.out.print(power[parent[c]]);
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
            int temp = aa;
            aa = bb;
            bb = temp;
        }

        parent[bb] = aa;
        power[aa] += power[bb];

        return true;
    }
}
