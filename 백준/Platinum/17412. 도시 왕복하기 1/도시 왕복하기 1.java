import java.io.*;
import java.util.*;

public class Main {
    static int source = 1, sink = 2;
    static int n, m;
    static int[][] capacity, flow;
    static List<Integer>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        capacity = new int[n+1][n+1];
        flow = new int[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list[s].add(e);
            list[e].add(s);
            capacity[s][e] = 1;
        }

        long cnt = 0;
        while(true) {
            int[] parent = new int[n+1];
            Arrays.fill(parent, -1);
            Queue<Integer> q = new ArrayDeque<>();
            parent[source] = source;
            q.add(source);

            while (!q.isEmpty() && parent[sink] == -1) {
                int cur = q.poll();
                for(int next : list[cur]) {
                    if(capacity[cur][next] - flow[cur][next] > 0 && parent[next] == -1) {
                        q.add(next);
                        parent[next] = cur;
                    }
                }
            }

            if(parent[sink] == -1) break;

            int minFlow = Integer.MAX_VALUE;
            for(int i = sink; i != source; i = parent[i]) {
                minFlow = Math.min(minFlow, capacity[parent[i]][i] - flow[parent[i]][i]);
            }

            for(int i = sink; i != source; i = parent[i]) {
                flow[parent[i]][i] += minFlow;
                flow[i][parent[i]] -= minFlow;
            }

            cnt += minFlow;
        }

        System.out.println(cnt);
    }
}
