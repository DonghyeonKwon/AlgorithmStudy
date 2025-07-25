import java.io.*;
import java.util.*;

public class Main {
    static int w, h;
    static char[][] map;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static Position start, end;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new char[h][w];

        int c = 0;
        for(int i = 0; i < h; i++) {
            String input = br.readLine();
            for(int j = 0; j < w; j++) {
                map[i][j] = input.charAt(j);
                if(map[i][j] == 'C') {
                    if(c == 0) {
                        start = new Position(i, j, -1, 0);
                        c++;
                    } else {
                        end = new Position(i, j, -1, 0);
                    }
                }
            }
        }

        System.out.print(bfs());
    }

    static int bfs() {
        PriorityQueue<Position> pq = new PriorityQueue<>();
        int[][][] cost = new int[4][h][w];
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < h; j++) {
                Arrays.fill(cost[i][j], Integer.MAX_VALUE);
            }
        }
        pq.add(start);

        int min = Integer.MAX_VALUE;

        while(!pq.isEmpty()) {
            Position pos = pq.poll();

            if(pos.y == end.y && pos.x == end.x) {
                min = Math.min(min, cost[pos.d][pos.y][pos.x]);
                continue;
            }

            for(int i = 0; i < 4; i++) {
                int ny = pos.y + dy[i];
                int nx = pos.x + dx[i];
                int ncost = pos.d == i || pos.d == -1 ? pos.cost : pos.cost + 1;

                if(pos.d != -1 && Math.abs(pos.d - i) == 2) continue;
                if(ny < 0 || ny >= h || nx < 0 || nx >= w) continue;
                if(map[ny][nx] == '*') continue;

                if(cost[i][ny][nx] > ncost) {
                    pq.add(new Position(ny, nx, i, ncost));
                    cost[i][ny][nx] = ncost;
                }
            }
        }

        return min;
    }

    static class Position implements Comparable<Position> {
        int y, x, d, cost;

        Position(int y, int x, int d, int cost) {
            this.y = y;
            this.x = x;
            this.d = d;
            this.cost = cost;
        }

        @Override
        public int compareTo(Position o) {
            return this.cost - o.cost;
        }
    }
}
