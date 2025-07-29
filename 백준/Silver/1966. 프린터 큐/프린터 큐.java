import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Queue<int[]> q = new ArrayDeque<>();
            int[] arr = new int[10];
            int now = 9;

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                int p = Integer.parseInt(st.nextToken());
                q.add(new int[]{i, p});
                arr[p]++;
            }

            int cnt = 1;
            while(!q.isEmpty()) {
                if(arr[now] <= 0) {
                    now--;
                    continue;
                }

                int[] pos = q.poll();

                if(now == pos[1]) {
                    if(pos[0] == m) break;
                    arr[now]--;
                    cnt++;
                } else {
                    q.add(pos);
                }

            }

            System.out.println(cnt);
        }
    }
}
