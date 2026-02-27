import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<Integer>[] list;
    static int[] ans = new int[3];
    static int[] value;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        value = new int[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            value[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        bfs();

        ans[0] = 1;
        ans[1] = 0;
        ans[2] = 1;
        for(int i = 2; i <= n; i++) {
            if(ans[1] < value[i]) {
                ans[1] = value[i];
                ans[0] = i;
                ans[2] = 1;
            } else if(ans[1] == value[i]) {
                ans[2]++;
            }
        }

        System.out.print(ans[0] + " " + ans[1] + " " + ans[2]);

    }

    static void bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{1, 0});
        value[1] = 0;

        while(!q.isEmpty()) {
            int[] pos = q.poll();

            for(int next : list[pos[0]]) {
                int nextDist = pos[1] + 1;
                if(value[next] > nextDist) {
                    value[next] = nextDist;
                    q.add(new int[]{next, nextDist});
                }
            }
        }
    }
}
