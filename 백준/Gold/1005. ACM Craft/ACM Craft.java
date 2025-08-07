import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] buildTime = new int[n+1];
            for(int i = 1; i <= n; i++) {
                buildTime[i] = Integer.parseInt(st.nextToken());
            }

            int[] degree = new int[n+1];
            List<List<Integer>> list = new ArrayList<>();
            for(int i = 0; i <= n; i++) {
                list.add(new ArrayList<>());
            }

            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.get(a).add(b);
                degree[b]++;
            }

            int w = Integer.parseInt(br.readLine());

            PriorityQueue<Pos> q = new PriorityQueue<>();
            for(int i = 1; i <= n; i++) {
                if(degree[i] == 0) {
                    q.add(new Pos(i, buildTime[i]));
                }
            }

            int res = 0;
//            List<Pos> next = new ArrayList<>();
            while(!q.isEmpty()) {
                Pos now = q.poll();

                if(now.cur == w) {
                    res = now.time;
                    break;
                }

                for(int idx : list.get(now.cur)) {
                    degree[idx]--;
                    if(degree[idx] == 0) {
                        q.add(new Pos(idx, now.time + buildTime[idx]));
                    }
                }
            }
            bw.write(res + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Pos implements Comparable<Pos> {
        int cur, time;

        Pos(int cur, int time) {
            this.cur = cur;
            this.time = time;
        }

        @Override
        public int compareTo(Pos o) {
            return this.time - o.time;
        }
    }
}
