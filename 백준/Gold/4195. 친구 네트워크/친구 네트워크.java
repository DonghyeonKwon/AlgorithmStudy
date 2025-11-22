import java.io.*;
import java.util.*;

public class Main {
    static int size = 100_001;
    static int[] parent, rank;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T --> 0) {
            int n = Integer.parseInt(br.readLine());

            parent = new int[size * 2];
            rank = new int[size * 2];
            for(int i = 1; i < 2* size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }

            int idx = 1;
            Map<String, Integer> map = new HashMap<>();

            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();
                if(!map.containsKey(a)) {
                    map.put(a, idx++);
                }
                if(!map.containsKey(b)) {
                    map.put(b, idx++);
                }

                int aa = map.get(a);
                int bb = map.get(b);
                int num = union(aa, bb);

                sb.append(num).append('\n');
            }
        }

        System.out.print(sb);
    }

    static int find(int x) {
        if(parent[x] == x) return x;
        int rx = find(parent[x]);
        return rx;
    }

    static int union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);

        if(aParent != bParent) {
            if(aParent > bParent) {
                parent[aParent] = bParent;
                rank[bParent] += rank[aParent];
                return rank[bParent];
            } else {
                parent[bParent] = aParent;
                rank[aParent] += rank[bParent];
            }
        }
        
        return rank[aParent];
    }
}
