import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static Map<Integer, Integer> parent = new HashMap<>();
    static char[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];

        for(int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }
        init();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int ny = i;
                int nx = j;
                if(map[i][j] == 'D') {
                    ny += 1;
                } else if(map[i][j] == 'L') {
                    nx -= 1;
                } else if(map[i][j] == 'U') {
                    ny -= 1;
                } else if(map[i][j] == 'R') {
                    nx += 1;
                }

                union(i * 10000 + j, ny * 10000 + nx);
            }
        }

        Set<Integer> set = new HashSet<>();
        for(int i : parent.keySet()) {
            int p = find(i);
            set.add(p);
        }

        System.out.print(set.size());
    }

    static void init() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int p = i * 10000 + j;
                parent.put(p, p);
            }
        }
    }

    static int find(int x) {
        if(x == parent.get(x)) return x;
        return parent.get(find(parent.get(x)));
    }

    static void union(int a, int b) {
        int aa = find(a);
        int bb = find(b);

        if(aa == bb) return;

        if(aa > bb) {
            parent.put(aa, bb);
        } else {
            parent.put(bb, aa);
        }
    }
}
