import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());

            bw.write(bfs(num, dest));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static String bfs(int num, int dest) {
        Queue<Node> q = new ArrayDeque<>();
        boolean[] visited = new boolean[10000];
        String answer = null;
        q.add(new Node(num, ""));
        visited[num] = true;
        char[] arr = {'D', 'S', 'L', 'R'};

        while(!q.isEmpty()) {
            Node now = q.poll();

            if(now.num == dest) {
                answer = now.method;
            }

            for(char c : arr) {
                if(c == 'D') {
                    int next = (now.num * 2) % 10000;
                    if(visited[next]) continue;

                    visited[next] = true;
                    q.add(new Node(next, now.method + c));
                } else if(c == 'S') {
                    int next = now.num == 0 ? 9999 : now.num - 1;
                    if(visited[next]) continue;

                    visited[next] = true;
                    q.add(new Node(next, now.method + c));
                } else if(c == 'L') {
                    int next =  (now.num % 1000) * 10 + now.num / 1000;
                    if(visited[next]) continue;

                    visited[next] = true;
                    q.add(new Node(next, now.method + c));
                } else if(c == 'R') {
                    int next =  (now.num / 10) + (now.num % 10) * 1000;
                    if(visited[next]) continue;

                    visited[next] = true;
                    q.add(new Node(next, now.method + c));
                }
            }
        }

        return answer + '\n';
    }

    static class Node {
        int num;
        String method;

        Node (int num, String method) {
            this.num = num;
            this.method = method;
        }
    }
}
