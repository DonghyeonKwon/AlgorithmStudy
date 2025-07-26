import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        int max = -1;
        int min = 201;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
                min = Math.min(min, map[i][j]);
            }
        }

        int answer = search(max, min);

        System.out.print(answer);
    }

    static int search(int max, int min) {
        int start = 0;
        int end = max - min;

        int result = 201;

        while(start <= end) {
            int mid = (start + end) / 2;
            boolean flag = false;
            for(int i = min; i + mid <= max; i++) {
                int s = i;
                int e = i + mid;
                if(map[0][0] >= s && map[0][0] <= e) {
                    if(bfs(s, e)) {
                        flag = true;
                        break;
                    }
                }
            }

            if(flag) {
                end = mid - 1;
                result = Math.min(result, mid);
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    static boolean bfs(int s, int e) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];
        q.add(new int[]{0, 0});
        visited[0][0] = true;

        while(!q.isEmpty()) {
            int[] pos = q.poll();

            if(pos[0] == n-1 && pos[1] == n-1) {
                return true;
            }

            for(int i = 0; i < 4; i++) {
                int ny = pos[0] + dy[i];
                int nx = pos[1] + dx[i];

                if(ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                if(visited[ny][nx]) continue;
                if(map[ny][nx] < s || map[ny][nx] > e) continue;
                q.add(new int[]{ny, nx});
                visited[ny][nx] = true;
            }
        }

        return false;
    }
}
