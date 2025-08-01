import java.io.*;
import java.util.*;

public class Main {
    static int n, max = -1, max_idx = -1;
    static List<Node>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }


        for(int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[parent].add(new Node(child, weight));
            list[child].add(new Node(parent, weight));
        }

        visited = new boolean[n+1];
        visited[1] = true;
        dfs(1, 0);

        visited = new boolean[n+1];
        visited[max_idx] = true;
        dfs(max_idx, 0);

        System.out.println(max);
    }

    static void dfs(int idx, int cost) {
        if(max < cost) {
            max = cost;
            max_idx = idx;
        }

        for(Node next : list[idx]) {
            if(!visited[next.v]) {
                visited[next.v] = true;
                dfs(next.v, cost + next.c);
            }
        }
    }


    static class Node {
        int v, c;

        Node(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }
}
