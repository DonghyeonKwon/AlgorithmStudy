import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] list = new ArrayList[n+1];
        int[] degree = new int[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            degree[b]++;
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int i = 1; i <= n; i++) {
            if(degree[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();

        while(!q.isEmpty()) {
            int now = q.poll();
            ans.add(now);
            for(int next : list[now]) {
                degree[next]--;
                if(degree[next] == 0) {
                    q.add(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int p : ans) {
            sb.append(p + " ");
        }

        System.out.print(sb);
    }
}
