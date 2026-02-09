import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] values;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int connected = 0;
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(union(a, b)) connected++;
        }

        values = new int[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                values[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        PriorityQueue<int[]>pq = new PriorityQueue<>(
                (a, b) -> a[2] - b[2]
        );

        for(int i = 2; i <= n; i++) {
            for(int j = i+1; j <= n; j++) {
                if(parent[i] != parent[j]) {
                    pq.add(new int[]{i, j, values[i][j]});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        int answer = 0;

        while(!pq.isEmpty() && connected < n - 2) {
            int[] now = pq.poll();

            if(union(now[0], now[1])) {
                sb.append(now[0]).append(" ").append(now[1]).append('\n');
                cnt++;
                answer += now[2];
                connected++;
            }
        }

        System.out.println(answer + " " + cnt);
        if(cnt > 0)System.out.print(sb);

    }

    static int find(int x) {
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b) {
        int aa = find(a);
        int bb = find(b);

        if(aa == bb) return false;

        if(aa > bb) {
            int tmp = aa;
            aa = bb;
            bb = tmp;
        }

        parent[bb] = aa;

        return true;
    }
}
