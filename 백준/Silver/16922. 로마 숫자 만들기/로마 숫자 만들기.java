import java.io.*;
import java.util.*;

public class Main {

    static int[] d = {1, 5, 10, 50};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.print(go(n));
    }

    static int go(int n) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n+1][1001];
        for(int i = 0; i < 4; i++) {
            q.add(new int[] {d[i], 1});
            visited[1][d[i]] = true;
        }

        int cnt = 0;

        while(!q.isEmpty()) {
            int[] pos = q.poll();

            if(pos[1] == n) {
                cnt++;
                continue;
            }

            for(int i = 0; i < 4; i++) {
                int nNum = pos[0] + d[i];
                int nCnt = pos[1] + 1;
                if(visited[nCnt][nNum]) continue;
                visited[nCnt][nNum] = true;
                q.add(new int[]{nNum, nCnt});
            }
        }

        return cnt;
    }
}
