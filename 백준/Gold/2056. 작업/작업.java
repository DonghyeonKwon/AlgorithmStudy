import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] list;
    static int[] sets;
    static int[] times;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        sets = new int[n+1];
        times = new int[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((o, p) -> o[1] - p[1]);
        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());

            int m = Integer.parseInt(st.nextToken());
            if(m == 0) {
                q.add(new int[]{i, times[i]});
                continue;
            }

            for(int j = 0; j < m; j++) {
                int k = Integer.parseInt(st.nextToken());
                list[k].add(i);
                sets[i]++;
            }
        }

        int cnt = 0;
        while(!q.isEmpty()) {
            int[] task = q.poll();
            cnt++;
            
            if(cnt == n) {
                System.out.print(task[1]);
                break;
            }

            for(int next : list[task[0]]) {
                sets[next]--;
                if(sets[next] == 0) {
                    q.add(new int[]{next, task[1] + times[next]});
                }
            }
        }
    }
}
