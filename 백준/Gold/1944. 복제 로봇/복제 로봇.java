import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static char[][] map;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static int[][] location;
    static int[] parent;
    static int[][] value;
    static boolean flag = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][n];
        location = new int[m+1][2];
        int idx = 1;
        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            for(int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j);

                if(map[i][j] == 'S') {
                    location[0][0] = i;
                    location[0][1] = j;
                } else if(map[i][j] == 'K') {
                    location[idx][0] = i;
                    location[idx++][1] = j;
                }
            }
        }

        parent = new int[m+1];
        value = new int[m+1][m+1];
        for(int i = 0; !flag && i <= m; i++) {
            parent[i] = i;
            bfs(i, location[i]);
        }

        if(flag) {
            System.out.print(-1);
            return;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[2] - b[2]
        );
        for(int i = 0; i <= m; i++) {
            for(int j = i+1; j <= m; j++) {
                pq.add(new int[]{i, j, value[i][j]});
            }
        }

        int sum = 0;
        int cnt = 0;
        while(!pq.isEmpty()) {
            int[] pos = pq.poll();

            int a = pos[0];
            int b = pos[1];
            int val = pos[2];

            if(union(a, b)) {
                cnt++;
                sum += val;
            }

            if(cnt == m) break;
        }

        System.out.print(sum);
    }

    static int find(int x) {
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b) {
        int aa = find(a);
        int bb = find(b);

        if(aa == bb) return false;

        if(aa > bb) {
            int tmp = aa;
            aa = bb;
            bb = tmp;
        }

        parent[bb] = aa;

        return true;
    }

    static void bfs(int idx, int[] start) {
        Queue<int[]> q = new ArrayDeque<>();
        int[][] visited = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        q.add(start);
        visited[start[0]][start[1]] = 0;
        int cnt = 0;

        while(!q.isEmpty()) {
            int[] pos = q.poll();
            int y = pos[0];
            int x = pos[1];

            if(cnt == m) break;

            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                if(map[ny][nx] == '1') continue;
                if(visited[ny][nx] <= visited[y][x] + 1) continue;
                if(map[ny][nx] == 'K' || map[ny][nx] == 'S') cnt++;
                visited[ny][nx] = visited[y][x] + 1;
                q.add(new int[]{ny, nx});
            }
        }

        for(int i = 0; i <= m; i++) {
            value[idx][i] = visited[location[i][0]][location[i][1]];
            if(value[idx][i] == Integer.MAX_VALUE) flag = true;
        }

    }
}
