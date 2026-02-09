import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<Edge>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Edge(b, c));
            list[b].add(new Edge(a, c));
        }

        int[] arr = bfs(1, 0);
        int[] brr = bfs(arr[0], 0);

        System.out.print(Math.max(bfs(arr[0], brr[0])[1], bfs(brr[0], arr[0])[1]));
    }

    static int[] bfs(int node, int notGo) {
        boolean[] visited = new boolean[n+1];
        Queue<int[]> q = new ArrayDeque<>();
        visited[node] = true;
        visited[notGo] = true;
        q.add(new int[]{node, 0});

        int max = 0;
        int max_idx = 0;
        while(!q.isEmpty()) {
            int[] pos = q.poll();

            if(pos[1] > max) {
                max = pos[1];
                max_idx = pos[0];
            }

            for(Edge next : list[pos[0]]) {
                if(visited[next.v]) continue;
                visited[next.v] = true;
                q.add(new int[]{next.v, pos[1] + next.c});
            }
        }

        return new int[]{max_idx, max};
    }

    static class Edge {
        int v, c;

        Edge(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }
}
