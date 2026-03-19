import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] degree;
    static List<Edge>[] list, revList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        degree = new int[n+1];
        list = new ArrayList[n+1];
        revList = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            revList[i] = new ArrayList<>();
        }

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Edge(b, c));
            revList[b].add(new Edge(a, c));
            degree[b]++;
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        bfs(a, b);
    }

    static void bfs(int a, int b) {
        Queue<Edge> q = new ArrayDeque<>();
        int[] value = new int[n+1];
        q.add(new Edge(a, 0));

        while(!q.isEmpty()) {
            Edge pos = q.poll();

            for(Edge next : list[pos.v]) {
                value[next.v] = Math.max(value[next.v], next.c + pos.c);
                if(--degree[next.v] == 0) {
                    q.add(new Edge(next.v, value[next.v]));
                }
            }
        }

        boolean[] visited = new boolean[n+1];
        q.add(new Edge(b, 0));
        int cnt = 0;

        while(!q.isEmpty()) {
            Edge now = q.poll();

            if(visited[now.v]) continue;
            visited[now.v] = true;

            for(Edge prev : revList[now.v]) {
                if(value[now.v] - prev.c == value[prev.v]) {
                    q.add(new Edge(prev.v, 0));
                    cnt++;
                }
            }
        }

        System.out.print(value[b] + "\n" + cnt);
    }

    static class Edge {
        int v, c;

        Edge(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }
}
