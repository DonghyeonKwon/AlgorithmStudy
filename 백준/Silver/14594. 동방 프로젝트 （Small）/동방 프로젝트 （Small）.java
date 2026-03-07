import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];

        for(int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        int m = Integer.parseInt(br.readLine());
        if(m == 0) {
            System.out.print(n);
            return;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> {
                    if(a[0] == b[0]) {
                        return b[1] - a[1];
                    }
                    return a[0] - b[0];
                }
        );

        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            pq.add(new int[]{a, b});
        }

        int cnt = pq.peek()[0] - 1;
        int[] range = pq.poll();

        while(!pq.isEmpty()) {
            int[] next = pq.poll();

            if(range[1] < next[0]) {
                cnt++;
                for(int i = range[1] + 1; i < next[0]; i++) {
                    cnt++;
                }
                range = next;
            } else {
                if(range[1] < next[1]) {
                    range[1] = next[1];
                }
            }
        }

        cnt++;
        for(int i = range[1] + 1; i <= n; i++) {
            cnt++;
        }

        System.out.print(cnt);
    }
}
