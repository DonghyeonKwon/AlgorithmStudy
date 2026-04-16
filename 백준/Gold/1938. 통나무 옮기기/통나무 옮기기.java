import java.io.*;
import java.util.*;

public class Main {
    static int n, min = Integer.MAX_VALUE;
    static int ey, ex, es;
    static char[][] map;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];

        for(int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        Tree t = null;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 'B') {
                    if(i + 1 < n && i - 1 >= 0 && map[i+1][j] == 'B' && map[i-1][j] == 'B') {
                        map[i][j] = '0';
                        map[i+1][j] = '0';
                        map[i-1][j] = '0';
                        t = new Tree(i, j, 1, 0);
                    } else if(j + 1 < n && j - 1 >= 0 && map[i][j+1] == 'B' && map[i][j-1] == 'B') {
                        map[i][j] = '0';
                        map[i][j-1] = '0';
                        map[i][j+1] = '0';
                        t = new Tree(i, j, 0, 0);
                    }
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j] == 'E') {
                    if(i + 1 < n && i - 1 >= 0 && map[i+1][j] == 'E' && map[i-1][j] == 'E') {
                        ey = i;
                        ex = j;
                        es = 1;
                    } else if(j + 1 < n && j - 1 >= 0 && map[i][j+1] == 'E' && map[i][j-1] == 'E') {
                        ey = i;
                        ex = j;
                        es = 0;
                    }
                }
            }
        }

        go(t);
        System.out.print(min == Integer.MAX_VALUE ? 0 : min);
    }

    static void go(Tree t) {
        Queue<Tree> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[2][n][n];
        visited[t.s][t.y][t.x] = true;
        q.add(t);

        while(!q.isEmpty()) {
            Tree now = q.poll();

            if(now.y == ey && now.x == ex && now.s == es) {
                min = Math.min(now.cnt, min);
                break;
            }

            for(int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if(ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                if(now.s == 1 && (ny + 1 >= n || ny - 1 < 0)) continue;
                if(now.s == 0 && (nx + 1 >= n || nx - 1 < 0)) continue;
                if(map[ny][nx] == '1') continue;
                if(now.s == 1 && (map[ny + 1][nx] == '1' || map[ny - 1][nx] == '1')) continue;
                if(now.s == 0 && (map[ny][nx + 1] == '1' || map[ny][nx - 1] == '1')) continue;
                if(visited[now.s][ny][nx]) continue;

                visited[now.s][ny][nx] = true;
                q.add(new Tree(ny, nx, now.s, now.cnt+1));
            }

            if(check(now) && !visited[(now.s + 1) % 2][now.y][now.x]) {
                visited[(now.s + 1) % 2][now.y][now.x] = true;
                q.add(new Tree(now.y, now.x, (now.s + 1) % 2, now.cnt + 1));
            }
        }
    }

    static boolean check(Tree t) {
        for(int y = t.y - 1; y <= t.y + 1; y++) {
            for(int x = t.x - 1; x <= t.x + 1; x++) {
                if(y < 0 || y >= n || x < 0 || x >= n) return false;
                if(map[y][x] == '1') return false;
            }
        }
        return true;
    }

    static class Tree {
        int y, x, s, cnt;

        Tree(int y, int x, int s, int cnt) {
            this.y = y;
            this.x = x;
            this.s = s;
            this.cnt = cnt;
        }
    }
}
