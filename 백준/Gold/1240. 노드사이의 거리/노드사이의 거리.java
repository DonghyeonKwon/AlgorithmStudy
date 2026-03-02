import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<int[]>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new int[]{b, c});
            list[b].add(new int[]{a, c});
        }


        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(bfs(a, b)).append('\n');
        }

        System.out.print(sb);
    }

    static int bfs(int start, int end) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        q.add(new int[]{start, 0});
        visited[start] = true;

        while(!q.isEmpty()) {
            int[] pos = q.poll();

            if(pos[0] == end) {
                return pos[1];
            }

            for(int[] next : list[pos[0]]) {
                if(visited[next[0]]) continue;
                visited[next[0]] = true;
                q.add(new int[]{next[0], next[1] + pos[1]});
            }
        }

        return -1;
    }
}
