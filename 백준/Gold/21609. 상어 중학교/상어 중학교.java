import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] baseBlock;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        while(true) {
            Group g = null;

            //그룹 찾기
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(map[i][j] > 0) {
                        Group tmp = bfs(i, j, map[i][j]);

                        if(tmp == null) continue;
                        if(g == null) {
                            g = tmp;
                        } else {
                            if(g.compareTo(tmp) < 0) {
                                g = tmp;
                            }
                        }
                    }
                }
            }

            if(g == null) break;

            for(int[] pos : g.list){
                map[pos[0]][pos[1]] = -2;
            }
            answer += (g.list.size() * g.list.size());
            
            //중력
            gravity();

            //회전
            rolate();

            //중력
            gravity();
        }

        System.out.print(answer);
    }

    static Group bfs(int y, int x, int num) {
        boolean[][] visited = new boolean[N][N];
        Group ret = new Group();
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{y, x});
        visited[y][x] = true;
        int zeroCnt = 0;
        int minY = 1000;
        int minX = 1000;

        while(!q.isEmpty()) {
            int[] pos = q.poll();
            ret.list.add(pos);

            y = pos[0];
            x = pos[1];

            if(map[y][x] == 0) zeroCnt++;
            else {
                if(minY > y) {
                    minX = x;
                    minY = y;
                } else if(minY == x) {
                    minX = Math.min(x, minX);
                }
            }

            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
                if(visited[ny][nx]) continue;
                if(map[ny][nx] < 0) continue;
                if(map[ny][nx] != 0 && map[ny][nx] != num) continue;

                visited[ny][nx] = true;
                q.offer(new int[]{ny, nx});
            }
        }

        if(ret.list.size() < 2) return null;
        ret.zeroCnt = zeroCnt;
        ret.minY = minY;
        ret.minX = minX;

        return ret;
    }

    static void gravity() {
        for(int j = 0; j < N; j++) {
            Stack<Integer> stk = new Stack<>();
            stk.push(map[N-1][j]);

            for(int i = N-2; i >= 0; i--) {
                if(map[i][j] >= 0) {
                    int k = 0;
                    while(!stk.isEmpty() && stk.peek() == -2){
                        stk.pop();
                        k++;
                    }
                    stk.push(map[i][j]);
                    while(k-- > 0) stk.push(-2);
                } else {
                    stk.push(map[i][j]);
                }

            }

            for(int i = 0; i < N; i++) {
                map[i][j] = stk.pop();
            }
        }
    }

    static void rolate() {
        int[][] tmp = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                tmp[N-1-j][i] = map[i][j];
            }
        }

        map = tmp;
    }

    static class Group implements Comparable<Group>{
        List<int[]> list;
        int zeroCnt;
        int minY;
        int minX;

        Group() {
            this.list = new ArrayList<>();
        }

        @Override
        public int compareTo(Group g){
            if(this.list.size() == g.list.size()) {
                if(this.zeroCnt == g.zeroCnt) {
                    if(this.minY == g.minY) {
                        return this.minX - g.minX;
                    }
                    return this.minY - g.minY;
                }
                return this.zeroCnt - g.zeroCnt;
            }

            return list.size() - g.list.size();
        }
    }
}
