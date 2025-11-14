import java.io.*;
import java.util.*;

public class Main {
    static int max = -1;
    static int n, m, start, end;
    static boolean[] visited;
    static List<Info>[] list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[start].add(new Info(end, cost));
            list[end].add(new Info(start, cost));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());


        int left = 0, right = 1_000_000_000;
        while(left <= right) {
            int mid = (left + right) / 2;

            visited = new boolean[n+1];
            max = -1;
            dfs(start, end, mid);
            if(max != -1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.print(right);
    }

    static void dfs(int now, int end, int limit) {
        if(now == end) {
            max = Math.max(limit, max);
            return;
        }

        visited[now] = true;

        for(Info next : list[now]) {
            if(!visited[next.city] && limit <= next.cost) {
                dfs(next.city, end, limit);
            }
        }
    }

    static class Info {
        int city, cost;

        Info(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }
    }
}