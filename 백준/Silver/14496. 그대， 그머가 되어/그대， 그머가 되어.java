import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        visited = new boolean[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(to);
            list[to].add(from);
        }

        System.out.print(bfs(a, b));
    }

    static int bfs(int a, int b) {
        PriorityQueue<int[]> q = new PriorityQueue<>(
                (o, p) -> o[1] - p[1]
        );
        q.add(new int[]{a, 0});
        visited[a] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            if(now[0] == b) {
                return now[1];
            }

            for(int next : list[now[0]]) {
                if(visited[next]) continue;
                visited[next] = true;
                q.add(new int[]{next, now[1] + 1});
            }
        }

        return -1;
    }
}
