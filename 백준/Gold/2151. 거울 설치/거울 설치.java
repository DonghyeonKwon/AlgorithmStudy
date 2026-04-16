import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static char[][] map;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static int[] start = new int[2], end = new int[2];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new char[n][n];

        boolean flag = false;
        for(int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();

            for(int j = 0; j < n; j++) {
                map[i][j] = input[j];
                if(input[j] == '#') {
                    if(flag) {
                        end[0] = i;
                        end[1] = j;
                    } else {
                        flag = true;
                        start[0] = i;
                        start[1] = j;
                    }
                }
            }
        }

        int answer = go();
        System.out.print(answer);
    }

    static int go(){
        int min = Integer.MAX_VALUE;
        PriorityQueue<Pos> pq = new PriorityQueue<>();
        boolean[][][] visited = new boolean[n][n][4];

        for(int i = 0; i < 4; i++) {
            pq.add(new Pos(start[0], start[1], i, 0));
        }

        while(!pq.isEmpty()) {
            Pos pos = pq.poll();

            int y = pos.y;
            int x = pos.x;
            int d = pos.d;
            int cost = pos.cost;

            visited[y][x][d] = true;

            if(y == end[0] && x == end[1]) {
                min = cost;
                break;
            }

            int ny = y + dy[d];
            int nx = x + dx[d];

            if(ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
            if(map[ny][nx] == '*') continue;
            if(visited[ny][nx][d]) continue;

            if(map[ny][nx] == '!') {
                int nd = (d + 3) % 4;
                pq.add(new Pos(ny, nx, nd, cost + 1));

                nd = (d + 1) % 4;
                pq.add(new Pos(ny, nx, nd, cost + 1));
            }

            pq.add(new Pos(ny, nx, d, cost));
        }

        return min;
    }

    static class Pos implements Comparable<Pos> {
        int y, x, d, cost;

        Pos(int y, int x, int d, int cost){
            this.y = y;
            this.x = x;
            this.d = d;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pos o) {
            return this.cost - o.cost;
        }
    }
}
