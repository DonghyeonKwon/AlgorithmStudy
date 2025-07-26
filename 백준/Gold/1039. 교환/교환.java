import java.io.*;
import java.util.*;

public class Main {
    static int n, k, answer = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs();

        System.out.print(answer);
    }

    static void bfs() {
        boolean[][] visited = new boolean[k+1][1000001];
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(n, 0));
        visited[0][n] = true;

        while(!q.isEmpty()) {
            Node n = q.poll();
            int num = n.num;
            int cnt = n.cnt;

            if(cnt == k) {
                answer = Math.max(answer, num);
                continue;
            }

            int len = String.valueOf(num).length();

            for(int i = 0; i < len - 1; i++) {
                for(int j = i+1; j < len; j++) {
                    int next = swap(num, i, j);

                    if(next != -1 && !visited[cnt+1][next]) {
                        q.add(new Node(next, cnt+1));
                        visited[cnt+1][next] = true;
                    }
                }
            }
        }
    }

    static int swap(int num, int i, int j) {
        char[] arr = String.valueOf(num).toCharArray();

        if(i == 0 && arr[j] == '0') return -1;

        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

        return Integer.parseInt(String.valueOf(arr));
    }

    static class Node {
        int num;
        int cnt;

        Node (int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}
