import java.io.*;
import java.util.*;

public class Main {
    static int n, V = 52, INF = 987654321;
    static int[][] flow, capacity;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        flow = new int[V][V];
        capacity = new int[V][V];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = atoi(st.nextToken().charAt(0));
            int b = atoi(st.nextToken().charAt(0));
            int value = Integer.parseInt(st.nextToken());

            capacity[a][b] += value;
            capacity[b][a] += value;
        }

        maxFlow(0, 25);
    }

    static void maxFlow(int src, int sink) {
        int totalFlow = 0;
        int[] parent = new int[V];
        Queue<Integer> q;
        while(true) {
            Arrays.fill(parent, -1);
            q = new ArrayDeque<>();

            parent[src] = src;
            q.add(src);

            while(!q.isEmpty() && parent[sink] == -1) {
                int cur = q.poll();
                for(int next = 0; next < V; next++) {
                    if(capacity[cur][next] - flow[cur][next] > 0 && parent[next] == -1) {
                        q.add(next);
                        parent[next] = cur;
                    }
                }
            }

            if(parent[sink] == -1) break;

            int amount = Integer.MAX_VALUE;
            for(int i = sink; i != src; i = parent[i]) {
                amount = Math.min(capacity[parent[i]][i] - flow[parent[i]][i], amount);
            }

            for(int i = sink; i != src; i = parent[i]) {
                flow[parent[i]][i] += amount;
                flow[i][parent[i]] -= amount;
            }

            totalFlow += amount;
        }

        System.out.print(totalFlow);
    }

    static int atoi(char c) {
        if('A' <= c && c <= 'Z') {
            return c - 'A';
        } else if('a' <= c && c <= 'z') {
            return 26 + c - 'a';
        }

         return -1;
    }
}
