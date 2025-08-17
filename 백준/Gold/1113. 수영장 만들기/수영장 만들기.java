import java.io.*;
import java.util.*;

public class Main {
    static int r, c, sum = 0;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        visited = new boolean[r][c];

        for(int i = 0; i < r; i++) {
            String input = br.readLine();
            for(int j = 0; j < c; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        for(int k = 1; k <= 9; k++) {
            for(int i = 0; i < r; i++) {
                for(int j = 0; j < c; j++) {
                    if(map[i][j] == k && !visited[i][j]) {
                        bfs(i, j, k);
                    }
                }
            }
        }

        System.out.print(sum);
    }

    static void bfs(int y, int x, int k) {
        Queue<int[]> q = new ArrayDeque<>();
        List<int[]> list = new ArrayList<>();
        q.add(new int[]{y, x});
        list.add(new int[]{y, x});

        visited[y][x] = true;
        int min = 10;
        boolean flag = false;

        while(!q.isEmpty()) {
            int[] now = q.poll();

            if(now[0] == 0 || now[0] == r-1 || now[1] == 0 || now[1] == c-1) {
                flag = true;
            }

            for(int i = 0; i < 4; i++) {
                int ny = now[0] + dy[i];
                int nx = now[1] + dx[i];

                if(0 <= ny && ny < r && 0 <= nx && nx < c) {
                    if(!visited[ny][nx] && map[ny][nx] == k) {
                        visited[ny][nx] = true;
                        q.add(new int[] {ny, nx});
                        list.add(new int[] {ny, nx});
                    }

                    if(map[ny][nx] < k) {
                        flag = true;
                    }

                    if(map[ny][nx] > k) {
                        min = Math.min(min, map[ny][nx]);
                    }
                }
            }
        }

        if(!flag) {
            sum += list.size() * (min - k);
            for(int[] pos : list){
                map[pos[0]][pos[1]] = min;
                visited[pos[0]][pos[1]] = false;
            }
        }
    }
}
