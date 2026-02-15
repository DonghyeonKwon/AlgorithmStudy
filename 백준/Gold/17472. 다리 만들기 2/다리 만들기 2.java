import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static boolean[][] visited;
    static int[][] map;
    static int[] parent;
    static PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[2] - b[2]
    );

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n][m];
        map = new int[n][m];


        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int idx = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, idx);
                    idx++;
                }
            }
        }

        parent = new int[idx];
        for(int i = 1; i < idx; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] != 0) {
                    search(i, j, map[i][j]);
                }
            }
        }

        int ans = 0;
        int cnt = 0;
        while(!pq.isEmpty()) {
            int[] edge = pq.poll();

            if(union(edge[0], edge[1])) {
                cnt++;
                ans += edge[2];
            }

            if(cnt == idx - 2) break;
        }

        System.out.print(cnt == idx - 2 ? ans : -1);

    }

    static int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b) {
        int aa = find(a);
        int bb = find(b);

        if(aa == bb) return false;

        if(aa > bb) {
            int temp = aa;
            aa = bb;
            bb = temp;
        }

        parent[bb] = aa;

        return true;
    }

    static void search(int y, int x, int idx) {
        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            int dist = 1;

            while(0 <= ny && ny < n && 0 <= nx && nx < m) {
                if(map[ny][nx] == idx) break;
                if(map[ny][nx] == 0) {
                    ny += dy[i];
                    nx += dx[i];
                    dist++;
                } else {
                    if(dist - 1 < 2) break;
                    pq.add(new int[]{idx, map[ny][nx], dist-1});
                    break;
                }
            }
        }
    }

    static void bfs(int y, int x, int idx) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y, x});
        visited[y][x] = true;
        map[y][x] = idx;

        while(!q.isEmpty()) {
            int[] pos = q.poll();
            y = pos[0];
            x = pos[1];

            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if(visited[ny][nx]) continue;
                if(map[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    map[ny][nx] = idx;
                    q.add(new int[]{ny, nx});
                }
            }
        }
    }
}
