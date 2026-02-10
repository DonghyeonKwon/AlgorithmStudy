import java.io.*;
import java.util.*;

public class Main {
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int s = Integer.parseInt(br.readLine());

        List<int[]>[] list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new int[]{b, c});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a ,b) -> a[1] - b[1]
        );
        boolean[] visited = new boolean[n+1];
        int[] values = new int[n+1];
        int cnt = 0;
        Arrays.fill(values, Integer.MAX_VALUE);
        values[s] = 0;
        pq.add(new int[]{s, 0});

        while(!pq.isEmpty()) {
            int[] arr = pq.poll();
            int now = arr[0];
            int value = arr[1];

            if(visited[now]) continue;
            cnt++;
            visited[now] = true;

            if(cnt == n) break;

            for(int[] next : list[now]) {
                if(!visited[next[0]] && values[next[0]] > value + next[1]) {
                    values[next[0]] = value + next[1];
                    pq.add(new int[]{next[0], values[next[0]]});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            sb.append(values[i] == INF ? "INF" : values[i]).append('\n');
        }
        System.out.print(sb);
    }
}
