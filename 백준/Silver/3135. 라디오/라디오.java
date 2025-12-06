import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[1001];
        visited[A] = true;
        q.add(new int[]{A, 0});
        for(int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            q.add(new int[]{k, 1});
            visited[k] = true;
        }

        int[] dd = {1, -1};
        while(!q.isEmpty()) {
            int[] now = q.poll();

            if(now[0] == B) {
                System.out.print(now[1]);
                break;
            }

            for(int i = 0; i < 2; i++) {
                int next = now[0] + dd[i];
                int ncnt = now[1] + 1;

                if(next < 1 || next >= 1000) continue;
                if(visited[next]) continue;
                visited[next] = true;
                q.add(new int[]{next, ncnt});
            }
        }
    }
}
