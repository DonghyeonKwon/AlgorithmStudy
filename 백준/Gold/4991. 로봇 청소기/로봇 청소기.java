import java.io.*;
import java.util.*;

public class Main {
    static int w, h, ry, rx, dirty = 0;
    static char[][] map;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0) break;

            map = new char[h][w];
            dirty = 0;
            char c = '0';

            for(int i = 0; i < h; i++) {
                char[] input = br.readLine().toCharArray();
                for(int j = 0; j < w; j++) {
                    map[i][j] = input[j];
                    if(input[j] == 'o') {
                        ry = i;
                        rx = j;
                        map[i][j] = '.';
                    } else if(map[i][j] == '*') {
                        dirty++;
                        map[i][j] = c;
                        c += 1;
                    }
                }
            }

            bw.write(Integer.toString(bfs(ry, rx)));
            bw.write('\n');
        }

        bw.flush();
        bw.close();
        br.close();

    }

    static int bfs(int y, int x) {
        PriorityQueue<Position> pq = new PriorityQueue<>();
        boolean[][][] visited = new boolean[h][w][1024];
        pq.offer(new Position(y, x, 0, 0));
        visited[y][x][0] = true;

        while(!pq.isEmpty()) {
            Position pos = pq.poll();

            if(pos.done == (1 << dirty) - 1) {
                return pos.cnt;
            }

            for(int i = 0; i < 4; i++) {
                int ny = pos.y + dy[i];
                int nx = pos.x + dx[i];
                int nc = pos.cnt + 1;
                int nd = pos.done;

                if(ny < 0 || ny >= h || nx < 0 || nx >= w) continue;
                if(map[ny][nx] == 'x') continue;
                if(visited[ny][nx][nd]) continue;

                if('0' <= map[ny][nx] && map[ny][nx] <= '9') {
                    int a = map[ny][nx] - '0';
                    if((nd & (1 << a)) == 0) {
                        nd |= (1 << a);
                    }
                }

                pq.offer(new Position(ny, nx, nc, nd));
                visited[ny][nx][nd] = true;
            }
        }

        return -1;
    }

    static class Position implements Comparable<Position> {
        int y, x, cnt, done;

        Position (int y, int x, int cnt, int done) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
            this.done = done;
        }

        @Override
        public int compareTo(Position o) {
            return this.cnt - o.cnt;
        }
    }
}
