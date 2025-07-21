import java.io.*;
import java.util.*;

public class Main {
    static int n, m, ly, lx;
    static char[][] map;
    static boolean[][] melted, visited;
    static Queue<int[]> waterQ, swanQ, waterTempQ, swanTempQ;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        waterQ = new ArrayDeque<>();
        waterTempQ = new ArrayDeque<>();
        swanQ = new ArrayDeque<>();
        swanTempQ = new ArrayDeque<>();

        map = new char[n][m];
        melted = new boolean[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            char[] arr = br.readLine().toCharArray();
            for(int j = 0; j < m; j++) {
                map[i][j] = arr[j];

                if(arr[j] == 'L') {
                    ly = i;
                    lx = j;
                }

                if(arr[j] == '.' || arr[j] == 'L') {
                    melted[i][j] = true;
                    waterQ.offer(new int[]{i, j});
                }
            }
        }

        swanQ.offer(new int[]{ly, lx});
        visited[ly][lx] = true;

        int time = 0;
        while(true) {
            if(swanBfs()) break;
            melting();
            waterQ = waterTempQ;
            swanQ = swanTempQ;
            waterTempQ = new ArrayDeque<>();
            swanTempQ = new ArrayDeque<>();
            time++;
        }

        System.out.print(time);
    }

    static boolean swanBfs() {
        while(!swanQ.isEmpty()) {
            int[] pos = swanQ.poll();
            int y = pos[0];
            int x = pos[1];

            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if(visited[ny][nx]) continue;

                visited[ny][nx] = true;

                if(map[ny][nx] == 'L') return true;
                else if(map[ny][nx] == '.') swanQ.offer(new int[]{ny, nx});
                else if(map[ny][nx] == 'X') swanTempQ.offer(new int[]{ny, nx});
            }
        }

        return false;
    }

    static void melting() {
        while(!waterQ.isEmpty()) {
            int[] pos = waterQ.poll();
            int y = pos[0];
            int x = pos[1];

            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if(melted[ny][nx]) continue;
                if(map[ny][nx] == 'X') {
                    melted[ny][nx] = true;
                    map[ny][nx] = '.';
                    waterTempQ.offer(new int[]{ny, nx});
                }
            }
        }
    }
}
