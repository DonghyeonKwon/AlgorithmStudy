import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            list[p].add(q);
            list[q].add(p);
        }

        int p = 0;
        int min = 100000000;
        for(int i = 1; i <= n; i++) {
            int val = bfs(i, n);
            if(val < min) {
                min = val;
                p = i;
            }
        }

        System.out.print(p);
    }

    static int bfs(int now, int n) {
        Queue<int[]> q = new ArrayDeque<>();
        int cnt = 0;
        boolean[] visited = new boolean[n+1];
        visited[now] = true;
        q.add(new int[]{now, 0});

        while(!q.isEmpty()) {
            int[] pos = q.poll();

            cnt += pos[1];

            for(int next : list[pos[0]]) {
                if(visited[next]) continue;

                visited[next] = true;
                q.add(new int[]{next, pos[1] + 1});
            }
        }

        return cnt;
    }
}
