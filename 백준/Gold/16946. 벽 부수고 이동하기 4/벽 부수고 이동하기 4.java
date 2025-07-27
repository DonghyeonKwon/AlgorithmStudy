import java.io.*;
import java.util.*;

public class Main {
    static int n, m, cnt = 1;
    static int[][] map, answer;
    static int[][] visited;
    static Map<Integer, Integer> hm = new HashMap<>();

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new int[n][m];
        answer = new int[n][m];

        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0 && visited[i][j] == 0) {
                    int count = bfs(i, j);
                    hm.put(cnt, count);
                    cnt++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                sb.append(mapCount(i, j));
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static int mapCount(int y, int x) {
        int sum = 1;

        if(map[y][x] == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
            if(map[ny][nx] == 1) continue;
            set.add(visited[ny][nx]);
        }

        for(int p : set) {
            sum += hm.get(p);
        }

        return sum % 10;
    }

    static int bfs(int y, int x) {
        Queue<int[]> q = new ArrayDeque<>();
        int count = 1;

        q.add(new int[]{y, x});
        visited[y][x] = cnt;

        while(!q.isEmpty()) {
            int[] pos = q.poll();

            for(int i = 0; i < 4; i++) {
                int ny = pos[0] + dy[i];
                int nx = pos[1] + dx[i];

                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if(map[ny][nx] == 1) continue;
                if(visited[ny][nx] > 0) continue;

                q.add(new int[]{ny, nx});
                visited[ny][nx] = cnt;
                count++;
            }
        }

        return count;
    }
}
