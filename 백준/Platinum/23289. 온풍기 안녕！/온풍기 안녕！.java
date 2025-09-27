import java.io.*;
import java.util.*;

public class Main {
    static int r, c, k;
    static int[][] map, temp;
    static boolean[][][][] wall;
    static List<int[]> machine = new ArrayList<>();
    static List<int[]> check = new ArrayList<>();

    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};

    static int[][] ddy = {
            {-1, 0, 1},
            {-1, 0, 1},
            {-1, -1, -1},
            {1, 1, 1}
    };
    static int[][] ddx = {
            {1, 1, 1},
            {-1, -1, -1},
            {-1, 0, 1},
            {-1, 0, 1}
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new int[r+1][c+1];
        wall = new boolean[r+1][c+1][r+1][c+1];
        for(int i = 1; i <= r; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 5) {
                    check.add(new int[]{i, j});
                } else if(map[i][j] > 0){
                    machine.add(new int[]{i, j, map[i][j] - 1});
                }

                map[i][j] = 0;
            }
        }

        int w = Integer.parseInt(br.readLine());
        for(int i = 0; i < w; i++) {
            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            if(t == 0) {
                wall[y][x][y-1][x] = true;
                wall[y-1][x][y][x] = true;
            } else {
                wall[y][x][y][x+1] = true;
                wall[y][x+1][y][x] = true;
            }
        }

        int cnt = 0;
        while (cnt <= 100 && !checkMap()) {
            workMachine();
            calcs();
            cnt++;
        }

        System.out.print(cnt);
    }

    static void workMachine() {
        temp = new int[r+1][c+1];

        for(int i = 0; i < machine.size(); i++) {
            bfs(machine.get(i)[0], machine.get(i)[1], machine.get(i)[2]);
        }

        for(int i = 1; i <= r; i++) {
            for(int j = 1; j <= c; j++) {
                map[i][j] += temp[i][j];
            }
        }
    }

    static void bfs(int y, int x, int d) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[r+1][c+1];

        int t = 5;
        int ny = y + dy[d];
        int nx = x + dx[d];

        visited[ny][nx] = true;
        temp[ny][nx] += 5;
        q.add(new int[]{ny, nx, 2});

        while(!q.isEmpty()) {
            int[] pos = q.poll();

            if(pos[2] > 5) continue;

            for(int i = 0; i < 3; i++) {
                ny = pos[0] + ddy[d][i];
                nx = pos[1] + ddx[d][i];
                if(ny < 1 || ny > r || nx < 1 || nx > c) continue;
                if(visited[ny][nx]) continue;
                if(isWall(pos[0], pos[1], ny, nx, d)) continue;
                visited[ny][nx] = true;
                temp[ny][nx] += t - pos[2] + 1;
                q.add(new int[]{ny, nx, pos[2] + 1});
            }
        }
    }

    static boolean isWall(int y, int x, int ny, int nx, int d) {
        if(y == ny || x == nx) {
            if(wall[y][x][ny][nx]) return true;
        } else {
            if(d == 0 || d == 1) {
                if(wall[y][x][ny][x] || wall[ny][x][ny][nx]) return true;
            } else {
                if(wall[y][x][y][nx] || wall[y][nx][ny][nx]) return true;
            }
        }

        return false;
    }

    static boolean checkMap() {
        for (int[] pos : check) {
            if (map[pos[0]][pos[1]] < k) return false;
        }
        return true;
    }

    static void calcs() {
        temp = new int[r+1][c+1];
        for(int i = 1; i <= r; i++) {
            for(int j = 1; j <= c; j++) {
                if(map[i][j] == 0) continue;
                calc(i, j);
            }
        }

        for(int i = 1; i <= r; i++) {
            for(int j = 1; j <= c; j++) {
                map[i][j] += temp[i][j];
                if(i == 1 || i == r || j == 1 || j == c) {
                    if(map[i][j] > 0) map[i][j] -= 1;
                }
            }
        }
    }

    static void calc(int y, int x) {
        for(int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            if(ny < 1 || ny > r || nx < 1 || nx > c) continue;
            if(wall[y][x][ny][nx]) continue;
            if(map[y][x] > map[ny][nx]) {
                int tmp = ((map[y][x] - map[ny][nx]) / 4);
                temp[y][x] -= tmp;
                temp[ny][nx] += tmp;
            }
        }
    }
}
