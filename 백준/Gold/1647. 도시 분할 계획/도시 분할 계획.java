import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
            set.add(i);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[2] - b[2]
        );

        while(m-->0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new int[]{a, b, c});
        }

        int sum = 0;
        while(set.size() > 2) {
           int[] pos = pq.poll();

           if(union(pos[0], pos[1])) {
               sum += pos[2];
           }
        }

        System.out.print(sum);
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
            int tmp = aa;
            aa = bb;
            bb = tmp;
        }

        set.remove(bb);
        parent[bb] = aa;

        return true;
    }
}
