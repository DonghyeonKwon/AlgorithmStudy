import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] map;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static int[] ddy = {0, 1, 0, -1};
    static int[] ddx = {-1, 0, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;

        while(m-- > 0) {
            st = new StringTokenizer(br.readLine());

            int d = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());

            //얼음공격
            for(int i = 1; i <= s; i++) {
                int ny = (n+1) / 2 + dy[d] * i;
                int nx = (n+1) / 2 + dx[d] * i;

                if(ny < 1 || ny > n || nx < 1 || nx > n) break;
                map[ny][nx] = 0;
            }

            //빈칸 밀기 (Queue에 데이터를 넣는다)
            Queue<Integer> q = new ArrayDeque<>();
            int y = (n+1) / 2;
            int x = (n+1) / 2;
            int dis = 1;
            int disTemp = 1;
            int turn = 0;
            int dd = 0;

            while(true) {
                y += ddy[dd];
                x += ddx[dd];

                if(y < 1 || y > n || x < 1 || x > n) break;

                if(map[y][x] != 0) {
                    q.add(map[y][x]);
                }

                dis--;
                if(dis == 0) {
                    dd += 1;
                    dd %= 4;

                    turn++;
                    if(turn % 2 == 0) {
                        disTemp++;
                        dis = disTemp;
                    } else {
                        dis = disTemp;
                    }
                }
            }

            if(q.isEmpty()) break;

            //폭발
            while(true) {
                Queue<Integer> temp = new ArrayDeque<>();
                Stack<Integer> stk = new Stack<>();

                boolean flag = true;
                while(!q.isEmpty()) {
                    if(stk.isEmpty()) {
                        stk.push(q.poll());
                        continue;
                    }

                    int num = stk.peek();

                    if(num != q.peek()) {
                        if(stk.size() < 4) {
                            for(int i = 0; i < stk.size(); i++) {
                                temp.add(stk.peek());
                            }
                        } else {
                            ans += stk.peek() * stk.size();
                            flag = false;
                        }

                        stk.clear();
                    } else {
                        stk.push(q.poll());
                    }
                }

                if(stk.size() < 4) {
                    for(int i = 0; i < stk.size(); i++) {
                        temp.add(stk.peek());
                    }
                } else {
                    ans += stk.peek() * stk.size();
                }
                stk.clear();

                q = temp;
                if(flag) break;
            }

            if(q.isEmpty()) break;

            //그룹 처리
            Queue<Integer> temp = new ArrayDeque<>();
            int prev = q.poll();
            int cnt = 1;
            while(!q.isEmpty()) {
                int next = q.poll();

                if(prev == next) {
                    cnt++;
                } else {
                    temp.add(cnt);
                    temp.add(prev);

                    prev = next;
                    cnt = 1;
                }
            }

            temp.add(cnt);
            temp.add(prev);

            y = (n+1) / 2;
            x = (n+1) / 2;
            dis = 1;
            disTemp = 1;
            turn = 0;
            dd = 0;

            int[][] nextMap = new int[n+1][n+1];
            while(true) {
                y += ddy[dd];
                x += ddx[dd];

                if(temp.isEmpty() || y < 1 || y > n || x < 1 || x > n) break;

                nextMap[y][x] = temp.poll();

                dis--;
                if(dis == 0) {
                    dd += 1;
                    dd %= 4;

                    turn++;
                    if(turn % 2 == 0) {
                        disTemp++;
                        dis = disTemp;
                    } else {
                        dis = disTemp;
                    }
                }
            }
            map = nextMap;
        }

        System.out.print(ans);
    }
}
