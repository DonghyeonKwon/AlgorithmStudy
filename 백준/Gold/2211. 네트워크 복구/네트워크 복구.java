import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<int[]>[] list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[3];
            for(int j = 0; j < 3; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            list[arr[0]].add(new int[]{arr[1], arr[2]});
            list[arr[1]].add(new int[]{arr[0], arr[2]});
        }

        sb.append(n-1).append('\n');
        dijkstra();

        System.out.print(sb);
    }

    static void dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[1] - b[1]
        );
        boolean[] visited = new boolean[n+1];
        int[] value = new int[n+1];
        Arrays.fill(value, Integer.MAX_VALUE);
        value[1] = 0;
        visited[1] = true;
        int cnt = 1;

        for(int[] next : list[1]) {
            if(value[next[0]] > next[1]) {
                value[next[0]] = next[1];
                pq.add(new int[]{next[0], next[1], 1});
            }
        }

        while(!pq.isEmpty()) {
            int[] now = pq.poll();

            if(visited[now[0]]) continue;
            cnt++;
            sb.append(now[2]).append(' ').append(now[0]).append('\n');
            visited[now[0]] = true;

            if(cnt == n) break;
            for(int[] next : list[now[0]]) {
                if(value[next[0]] > now[1] + next[1]) {
                    value[next[0]] = now[1] + next[1];
                    pq.add(new int[]{next[0], value[next[0]], now[0]});
                }
            }
        }
    }
}
