import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][2];
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{0, 0});

        int cnt = 0;
        int res = -1;
        int sum = 0;
        while(!pq.isEmpty()) {
            int[] now = pq.poll();

            if(visited[now[0]]) continue;
            visited[now[0]] = true;
            cnt++;
            sum += now[1];

            if(cnt == n) {
                res = sum;
                break;
            }

            for(int i = 0; i < n; i++) {
                if(visited[i]) continue;
                if(i == now[0]) continue;

                int k = (map[now[0]][0] - map[i][0]) * (map[now[0]][0] - map[i][0]) + (map[now[0]][1] - map[i][1]) * (map[now[0]][1] - map[i][1]);
                if(k < c) continue;
                pq.add(new int[]{i, k});
            }
        }

        System.out.print(res);
    }
}
