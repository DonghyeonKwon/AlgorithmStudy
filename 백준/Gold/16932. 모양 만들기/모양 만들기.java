import java.io.*;
import java.util.*;

public class Main {
    static int n, m, max = 0;
    static int[] value;
    static int[][] map;
    static boolean[][] visited;
    static List<List<int[]>> set = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        set.add(new ArrayList<>());
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    set.add(new ArrayList<>());
                    int num = bfs(i, j, cnt + 1);
                    list.add(num);
                    cnt++;
                }
            }
        }

        if(cnt <= 1) {
            if(cnt == 0) System.out.print(1);
            else {
                if(list.get(0) == n * m) {
                    System.out.print(n * m - 1);
                } else {
                    System.out.print(list.get(0) + 1);
                }
            }
            return;
        }

        value = new int[cnt+1];
        for(int i = 0; i < cnt; i++) {
            value[i+1] = list.get(i);
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0) {
                    check(i, j);
                }
            }
        }

        System.out.print(max);
    }

    static void check(int y, int x) {
        int sum = 1;

        Set<Integer> set = new HashSet<>();
        set.add(0);
        for(int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
            if(!set.contains(map[ny][nx])) {
                sum += value[map[ny][nx]];
                set.add(map[ny][nx]);
            }
        }

        max = Math.max(max, sum);
    }

    static int bfs(int y, int x, int idx) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y, x});
        visited[y][x] = true;
        map[y][x] = idx;
        int cnt = 1;

        while(!q.isEmpty()) {
            int[] pos = q.poll();

            for(int i = 0; i < 4; i++) {
                int ny = pos[0] + dy[i];
                int nx = pos[1] + dx[i];

                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if(visited[ny][nx]) continue;
                if(map[ny][nx] != 1) {
                    set.get(idx).add(new int[]{pos[0], pos[1]});
                    continue;
                }
                map[ny][nx] = idx;
                visited[ny][nx] = true;
                q.add(new int[]{ny, nx});
                cnt++;
            }
        }

        return cnt;
    }
}
