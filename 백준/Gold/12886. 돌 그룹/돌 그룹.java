import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] stone = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 3; i++) {
            stone[i] = Integer.parseInt(st.nextToken());
        }

        int ans = bfs(stone);

        System.out.print(ans);
    }

    static int bfs(int[] stone) {
        if((stone[0] + stone[1] + stone[2]) % 3 != 0) return 0;

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[1501][1501];
        visited[stone[0]][stone[1]] = true;
        q.add(stone);

        while(!q.isEmpty()) {
            int[] now = q.poll();

            int a = now[0];
            int b = now[1];
            int c = now[2];

            if(a == b && b == c) return 1;

            if(a != b) {
               int na = a > b ? a - b : a * 2;
               int nb = a > b ? b * 2 : b - a;

               if(!visited[na][nb]) {
                   q.add(new int[]{na, nb, c});
                   visited[na][nb] = true;
               }
            }

            if(a != c) {
                int na = a > c ? a - c : a * 2;
                int nc = a > c ? c * 2 : c - a;

                if(!visited[na][nc]) {
                    q.add(new int[]{na, b, nc});
                    visited[na][nc] = true;
                }
            }

            if(b != c) {
                int nb = b > c ? b - c : b * 2;
                int nc = b > c ? c * 2 : c - b;

                if(!visited[nb][nc]) {
                    q.add(new int[]{a, nb, nc});
                    visited[nb][nc] = true;
                }
            }
        }

        return 0;
    }
}
