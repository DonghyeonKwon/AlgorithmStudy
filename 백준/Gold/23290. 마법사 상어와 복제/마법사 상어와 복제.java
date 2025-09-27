import java.io.*;
import java.util.*;

public class Main {

    static int sy, sx, num = 0;
    static int bite = -1, min = 999;
    static int[][] visited;
    static boolean[] dead = new boolean[1000001];
    static List<Integer>[][] map = new ArrayList[5][5];
    static int[][] smell = new int[5][5];
    static List<Fish> fishes;

    static int[] fy = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] fx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, 0, 1, 0};
    static int[] dx = {0, 0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        fishes = new ArrayList<>();

        for(int i = 1; i <= 4; i++) {
            for(int j = 1; j <= 4; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            map[y][x].add(d);
        }

        st = new StringTokenizer(br.readLine());
        sy = Integer.parseInt(st.nextToken());
        sx = Integer.parseInt(st.nextToken());


        while(s-- > 0) {
            copyReady();
            moveFish();
            moveShark();
            downSmell();
            copyFish();
        }

        int cnt = 0;
        for(int i = 1; i <= 4; i++) {
            for(int j = 1; j <= 4; j++) {
                cnt += map[i][j].size();
            }
        }

        System.out.print(cnt);
    }

    static void copyReady() {
        fishes.clear();
        for(int i = 1; i <= 4; i++) {
            for(int j = 1; j <= 4; j++) {
                for(int d : map[i][j]) {
                    fishes.add(new Fish(i, j, d));
                }
            }
        }
    }

    static void moveFish() {
        List<Integer>[][] tempMap = new ArrayList[5][5];
        for(int i = 1; i <= 4; i++) {
            for(int j = 1; j <= 4; j++) {
                tempMap[i][j] = new ArrayList<>();
            }
        }

        for(int y = 1; y <= 4; y++) {
            for(int x = 1; x <= 4; x++) {
                for(int d : map[y][x]) {
                    boolean flag = true;
                    for(int j = 0; j < 8; j++) {
                        int nd = d - j;
                        if(nd <= 0) {
                            nd += 8;
                        }
                        int ny = y + fy[nd];
                        int nx = x + fx[nd];

                        if(ny < 1 || ny > 4 || nx < 1 || nx > 4) continue;
                        if(ny == sy && nx == sx) continue;
                        if(smell[ny][nx] > 0) continue;

                        tempMap[ny][nx].add(nd);
                        flag = false;
                        break;
                    }

                    if(flag) tempMap[y][x].add(d);
                }
            }
        }

        map = tempMap;
    }

    static void moveShark() {
        bite = -1;
        min = 999;
        visited = new int[5][5];
        dfs(sy, sx, 0, 0, 0);

        int d = min / 100;
        sy += dy[d];
        sx += dx[d];
        if(!map[sy][sx].isEmpty()) smell[sy][sx] = 3;
        map[sy][sx].clear();
        min %= 100;

        d = min / 10;
        sy += dy[d];
        sx += dx[d];
        if(!map[sy][sx].isEmpty()) smell[sy][sx] = 3;
        map[sy][sx].clear();
        min %= 10;

        d = min;
        sy += dy[d];
        sx += dx[d];
        if(!map[sy][sx].isEmpty()) smell[sy][sx] = 3;
        map[sy][sx].clear();
    }

    static void dfs(int y, int x, int idx, int cnt, int k) {
        if(idx == 3) {
            if(cnt > bite) {
                bite = cnt;
                min = k;
            } else if(cnt == bite) {
                if(min > k) {
                    min = k;
                }
            }

            return;
        }

        k *= 10;
        for(int d = 1; d <= 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            int nCnt = cnt;

            if(ny < 1 || ny > 4 || nx < 1 || nx > 4) continue;
            if(visited[ny][nx] == 0) {
                nCnt += map[ny][nx].size();
            }
            visited[ny][nx]++;
            dfs(ny, nx, idx + 1, nCnt, k + d);
            visited[ny][nx]--;
        }
    }

    static void downSmell() {
        for(int i = 1; i <= 4; i++) {
            for(int j = 1; j <= 4; j++) {
                if(smell[i][j] > 0) smell[i][j]--;
            }
        }
    }

    static void copyFish() {
        for(Fish f : fishes) {
            map[f.y][f.x].add(f.d);
        }
    }

    static class Fish {
        int y, x, d;

        Fish(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }
}
