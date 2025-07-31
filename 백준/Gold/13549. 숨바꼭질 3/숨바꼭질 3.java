import java.io.*;
import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        bfs(n, k);

        System.out.print(min);
    }

    static void bfs(int n, int k) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(n, 0));

        boolean[] visited = new boolean[100001];


        while(!q.isEmpty()) {
            Node now = q.poll();
            visited[now.p] = true;
            if(now.p == k) min = Math.min(min, now.cost);

            if(now.p * 2 <= 100000 && !visited[now.p * 2]) q.add(new Node(now.p * 2, now.cost));
            if(now.p + 1 <= 100000 && !visited[now.p + 1]) q.add(new Node(now.p + 1, now.cost + 1));
            if(now.p - 1 >= 0 && !visited[now.p -1]) q.add(new Node(now.p - 1, now.cost + 1));
        }
    }

    static class Node{
        int p;
        int cost;

        Node(int p, int cost) {
            this.p = p;
            this.cost = cost;
        }
    }
}
