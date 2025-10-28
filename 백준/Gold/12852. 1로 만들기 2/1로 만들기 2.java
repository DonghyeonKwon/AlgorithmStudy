import java.io.*;
import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int[] dp, prev;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if(n == 1) {
            System.out.println("0\n1");
            return;
        }
        
        dp = new int[n+1];
        prev = new int[n+1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        go(n, 0);

        int i = 1;
        List<Integer> list = new ArrayList<>();
        while(true) {
            list.add(i);
            if(i == n) break;
            i = prev[i];
        }

        System.out.println(dp[1]);
        for(int j = list.size() - 1; j >= 0; j--) {
            System.out.print(list.get(j) + " ");
        }
    }

    static void go(int n, int cnt) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{n, cnt});

        while(!q.isEmpty()) {
            int[] now = q.poll();

            if(now[0] == 1) continue;

            if(now[0] % 3 == 0) {
                if(dp[now[0] / 3] > now[1] + 1) {
                    dp[now[0] / 3] = now[1] + 1;
                    prev[now[0] / 3] = now[0];
                    q.add(new int[]{now[0] / 3, now[1] + 1});
                }
            }

            if(now[0] % 2 == 0) {
                if(dp[now[0] / 2] > now[1] + 1) {
                    dp[now[0] / 2] = now[1] + 1;
                    prev[now[0] / 2] = now[0];
                    q.add(new int[]{now[0] / 2, now[1] + 1});
                }
            }

            if(dp[now[0] - 1] > now[1] + 1) {
                dp[now[0] - 1] = now[1] + 1;
                prev[now[0] - 1] = now[0];
                q.add(new int[]{now[0] - 1, now[1] + 1});
            }

        }
    }
}
