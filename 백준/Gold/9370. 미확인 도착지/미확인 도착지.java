import java.io.*;
import java.util.*;

public class Main {
    static int n, m, t, s, g, h;
    static List<int[]>[] list;
    static int[] arr;
    static int INF = 1000000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            list = new ArrayList[n+1];
            for(int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
            }
            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                if((a == g && b == h) || (a == h && b == g)){
                    list[a].add(new int[]{b, d * 2 - 1});
                    list[b].add(new int[]{a, d * 2 - 1});
                    continue;
                }
                list[a].add(new int[]{b, d*2});
                list[b].add(new int[]{a, d*2});
            }

            arr = new int[t];
            for(int i = 0; i < t; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(arr);

            int[] di = dijkstra();

            List<Integer> answer = new ArrayList<>();
            for(int i = 0; i < t; i++) {
                if(di[arr[i]] == INF) continue;
                if(di[arr[i]] % 2 == 1) answer.add(arr[i]);
            }

            for(int i : answer) {
                bw.write(Integer.toString(i));
                bw.write(" ");
            }
            bw.write("\n");

        }
        bw.flush();

        bw.close();
        br.close();
    }

    static int[] dijkstra() {
        int[] val = new int[n+1];
        boolean[] visited = new boolean[n+1];
        PriorityQueue<Pos> pq = new PriorityQueue<>();

        int cnt = 0;
        pq.add(new Pos(s, 0));
        Arrays.fill(val, INF);

        while(!pq.isEmpty()) {
            Pos pos = pq.poll();

            if(visited[pos.b]) continue;

            visited[pos.b] = true;
            cnt++;
            val[pos.b] = pos.cost;

            if(cnt == n) break;

            for(int[] d : list[pos.b]) {
                int next = d[0];
                int cost = d[1];

                if(visited[next]) continue;
                if(val[next] > pos.cost + cost) {
                    pq.add(new Pos(next, pos.cost+cost));
                }
            }
        }

        return val;
    }

    static class Pos implements Comparable<Pos> {
        int b, cost;

        Pos(int b, int cost) {
            this.b = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pos o) {
            return this.cost - o.cost;
        }
    }
}
