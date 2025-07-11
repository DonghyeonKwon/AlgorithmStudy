import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Queue<FireBall> q = new ArrayDeque<>();
        for(int i = 0; i < M; i++) {
            int r, c, m, s, d;
            st = new StringTokenizer(br.readLine());

            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            q.offer(new FireBall(r, c, m, s, d));
        }

        while(K-- > 0) {
            List<FireBall>[][] fbList = new ArrayList[N+1][N+1];

            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++){
                    fbList[i][j] = new ArrayList<>();
                }
            }

            while(!q.isEmpty()) {
                FireBall fb = q.poll();

                int s = fb.s % N;
                while(s-- > 0){
                    fb.y += dy[fb.d];
                    fb.x += dx[fb.d];

                    if(fb.y == N+1) fb.y = 1;
                    if(fb.x == N+1) fb.x = 1;
                    if(fb.y == 0) fb.y = N;
                    if(fb.x == 0) fb.x = N;
                }

                fbList[fb.y][fb.x].add(fb);
            }

            Queue<FireBall> tmp = new ArrayDeque<>();
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if(fbList[i][j].isEmpty()) continue;
                    if(fbList[i][j].size() == 1) {
                        tmp.offer(fbList[i][j].get(0));
                        continue;
                    }

                    int n = fbList[i][j].size();
                    FireBall sum = fbList[i][j].get(0);
                    if(sum.d % 2 == 0) sum.d = 0;
                    else sum.d = 1;
                    for(int p = 1; p < n; p++) {
                        sum.m += fbList[i][j].get(p).m;
                        sum.s += fbList[i][j].get(p).s;
                        sum.d = sum.d == fbList[i][j].get(p).d % 2 ? sum.d : 2;
                    }

                    if(sum.m / 5 == 0) continue;

                    if(sum.d == 2) {
                        for(int p = 1; p < 8; p += 2) {
                            tmp.offer(new FireBall(sum.y, sum.x, sum.m/5, sum.s/n, p));
                        }
                    } else {
                        for(int p = 0; p < 8; p += 2) {
                            tmp.offer(new FireBall(sum.y, sum.x, sum.m/5, sum.s/n, p));
                        }
                    }
                }

                q = tmp;
            }
        }

        int sum = 0;
        while(!q.isEmpty()) {
            sum += q.poll().m;
        }

        System.out.println(sum);
    }

    static class FireBall{
        int y, x, m, s, d;

        FireBall(){}

        FireBall(int y, int x, int m, int s, int d){
            this.y = y;
            this.x = x;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
}
