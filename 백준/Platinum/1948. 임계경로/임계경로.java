import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] degree;
    static List<Edge>[] list;
    static List<Edge>[] revList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        degree = new int[n+1];
        list = new ArrayList[n+1];
        revList = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            revList[i] = new ArrayList<>();
        }

        StringTokenizer st;
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
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        search(s, e);
    }

    static void search(int s, int e) {
        Queue<Edge> q = new ArrayDeque<>();
        int[] values = new int[n+1];
        q.add(new Edge(s, 0));

        while(!q.isEmpty()) {
            Edge pos = q.poll();

            for(Edge next : list[pos.v]) {
                values[next.v] = Math.max(values[next.v], pos.w + next.w);
                if(--degree[next.v] == 0) {
                    q.add(new Edge(next.v, values[next.v]));
                }
            }
        }

        boolean[] visited = new boolean[n+1];
        q.add(new Edge(e, 0));
        int cnt = 0;

        while(!q.isEmpty()) {
            Edge now = q.poll();

            if(visited[now.v]) continue;
            visited[now.v] = true;

            for(Edge next : revList[now.v]) {
                if(values[now.v] - next.w == values[next.v]) {
                    cnt++;
                    q.add(new Edge(next.v, 0));
                }
            }
        }

        System.out.print(values[e] + "\n" + cnt);
    }

    static class Edge{
        int v, w;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
