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
        }

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        if(t == 0) {
            System.out.print(m);
            return;
        }
        for(int i = 0; i < t; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer>[] partyList = new ArrayList[m];
        for(int i = 0; i < m; i++) {
            partyList[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int pn = Integer.parseInt(st.nextToken());

            int x = Integer.parseInt(st.nextToken());
            partyList[i].add(x);
            for(int j = 1; j < pn; j++) {
                int y = Integer.parseInt(st.nextToken());
                union(x, y);
                partyList[i].add(y);
            }
        }

        int cnt = 0;
        for(int i = 0; i < m; i++) {
            boolean flag = true;
            for(int num : partyList[i]) {
                if(set.contains(find(parent[num]))) {
                    flag = false;
                    break;
                }
            }

            if(flag) cnt++;
        }


        System.out.print(cnt);
    }

    static int find(int x) {
        if(parent[x] == x) return x;
        return find(parent[x]);
    }

    static void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if(set.contains(py)) {
            int tmp = px;
            px = py;
            py = tmp;
        }

        parent[py] = px;
    }
}
