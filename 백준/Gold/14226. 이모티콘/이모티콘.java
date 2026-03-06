import java.io.*;
import java.util.*;

public class Main {
    static int s;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = Integer.parseInt(br.readLine());
        arr = new int[2 * s + 1][2 * s + 1];
        for(int i = 1; i <= 2 * s; i++) {
            Arrays.fill(arr[i], Integer.MAX_VALUE);
        }

        bfs(1);

        int ans = Integer.MAX_VALUE;
        for(int i = 1; i <= 2*s; i++) {
            ans = Math.min(ans, arr[i][s]);
        }

        System.out.print(ans);
    }

    static void bfs(int node) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{node, 0, 0});
        arr[0][node] = 0;

        while(!q.isEmpty()) {
            int[] pos = q.poll();

            int now = pos[0];
            int board = pos[1];
            int cnt = pos[2];

            //복사
            int nB = now;
            if(arr[nB][now] > cnt + 1) {
                arr[nB][now] = cnt + 1;
                q.add(new int[]{now, nB, cnt+1});
            }

            //붙여넣기
            if(board > 0) {
                int next = now + board;
                if(next <= 2 * s && arr[board][next] > cnt + 1) {
                    arr[board][next] = cnt + 1;
                    q.add(new int[]{next, board, cnt+1});
                }
            }

            //하나 삭제
            if(now - 1 > 1) {
                int next = now - 1;
                if(arr[board][next] > cnt + 1) {
                    arr[board][next] = cnt + 1;
                    q.add(new int[]{next, board, cnt + 1});
                }
            }
        }
    }
}
