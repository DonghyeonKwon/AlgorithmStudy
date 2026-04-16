import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] prev = new int[100001];
    static int[] visited = new int[100001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= 100000; i++) {
            prev[i] = -1;
            visited[i] = Integer.MAX_VALUE;
        }

        bfs();

        sb.append(visited[n]).append('\n');
        for(int i = n; i != -1 ; i = prev[i]) {
            sb.append(i).append(' ');
        }

        System.out.print(sb);
    }

    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(k);
        visited[k] = 0;

        while(!q.isEmpty()) {
            int now = q.poll();

            if(now == n) break;
            int[] arr = {now - 1, now + 1};

            for(int next : arr) {
                if(next < 0 || next > 100000 || visited[next] <= visited[now] + 1) continue;
                q.add(next);
                visited[next] = visited[now] + 1;
                prev[next] = now;
            }

            if(now % 2 == 0 && visited[now/2] > visited[now] + 1) {
                q.add(now/2);
                visited[now/2] = visited[now] + 1;
                prev[now/2] = now;
            }
        }
    }
}
