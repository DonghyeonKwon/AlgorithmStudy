import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static List<int[]>[] list;
    static int[] val;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        val = new int[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        int left = 0;
        int right = 0;
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            right = Math.max(right, c);
            list[a].add(new int[]{b, c});
            list[b].add(new int[]{a, c});
        }

        int ans = -1;
        while(left <= right) {
            int mid = (left + right) / 2;

            if(bfs(mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.print(ans);
    }

    static boolean bfs(int mid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{1, 0});
        Arrays.fill(val, Integer.MAX_VALUE);
        val[1] = 0;

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int value = cur[1];

            if(val[now] < value) continue;

            for(int[] next : list[now]) {
                int nextValue = value;
                if(next[1] > mid) {
                    nextValue++;
                }

                if(nextValue < val[next[0]]) {
                    val[next[0]] = nextValue;
                    pq.add(new int[]{next[0], nextValue});
                }
            }
        }

        return val[n] <= k;
    }

}
