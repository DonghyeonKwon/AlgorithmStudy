import java.io.*;
import java.util.*;

public class Main {
    static int n, q;
    static List<Node>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v, c));
            list[v].add(new Node(u, c));
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            boolean[] visited = new boolean[n+1];
            visited[v] = true;
            Queue<Integer> q = new ArrayDeque<>();
            q.add(v);

            int ans = 0;
            while(!q.isEmpty()) {
                int cur = q.poll();

                for(Node next : list[cur]) {
                    if(!visited[next.v] && next.c >= k) {
                        q.add(next.v);
                        visited[next.v] = true;
                        ans++;
                    }
                }
            }

            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }

    static class Node {
        int v, c;

        Node(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }
}
