import java.io.*;
import java.util.*;

public class Main {
    static int F, S, G, U, D, f = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        go(S);
        System.out.print(f == Integer.MAX_VALUE ? "use the stairs" : f);
    }

    static void go(int now) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[F+1];
        q.offer(new int[]{now, 0});
        visited[now] = true;

        while(!q.isEmpty()) {
            int[] pos = q.poll();

            if(pos[0] == G) {
                f = pos[1];
                break;
            }

            if(pos[0] + U <= F && !visited[pos[0] + U]) {
                visited[pos[0] + U] = true;
                q.add(new int[]{pos[0] + U, pos[1] + 1});
            }

            if(pos[0] - D >= 1 && !visited[pos[0] - D]) {
                visited[pos[0] - D] = true;
                q.add(new int[]{pos[0] - D, pos[1] + 1});
            }
        }
    }
}
