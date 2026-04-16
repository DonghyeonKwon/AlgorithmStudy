import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][][] minBoard;
    static char[][] map;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            map = new char[n+2][m+2];
            minBoard = new int[3][n+2][m+2];
            for(int i = 0; i < n+2; i++) {
                Arrays.fill(map[i], '.');
                for(int j = 0; j < 3; j++) {
                    Arrays.fill(minBoard[j][i], 999999999);
                }
            }

            List<Position> list = new ArrayList<>();
            list.add(new Position(0, 0, 0));

            for(int i = 1; i <= n; i++) {
                char[] arr = br.readLine().toCharArray();
                for(int j = 0; j < m; j++) {
                    map[i][j+1] = arr[j];

                    if(arr[j] == '$') {
                        list.add(new Position(i, j+1, 0));
                        map[i][j+1] = '.';
                    }
                }
            }

            for(int i = 0; i < 3; i++) {
                bfs(list.get(i), i);
            }

            int result = Integer.MAX_VALUE;

            for(int i = 0; i < n+2; i++) {
                loop : for(int j = 0; j < m+2; j++) {
                    if(map[i][j] == '*') continue;

                    int sum = 0;
                    for(int k = 0; k < 3; k++) {
                        if(minBoard[k][i][j] == 999999999) continue loop;
                        sum += minBoard[k][i][j];
                    }

                    if(map[i][j] == '#') sum -= 2;

                    result = Math.min(sum, result);
                }
            }

            bw.write(Integer.toString(result));
            bw.write('\n');
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(Position pos, int num) {
        PriorityQueue<Position> q = new PriorityQueue<>();
        q.offer(pos);
        minBoard[num][pos.y][pos.x] = 0;
        boolean[][] visited = new boolean[n+2][m+2];
        visited[pos.y][pos.x] = true;

        while(!q.isEmpty()) {
            pos = q.poll();

            for(int i = 0; i < 4; i++) {
                int ny = pos.y + dy[i];
                int nx = pos.x + dx[i];
                int ncnt = pos.cnt;

                if(ny < 0 || ny >= n+2 || nx < 0 || nx >= m+2) continue;
                if(map[ny][nx] == '*') continue;
                if(visited[ny][nx]) continue;
                if(map[ny][nx] == '#') ncnt += 1;

                minBoard[num][ny][nx] = ncnt;
                visited[ny][nx] = true;
                q.offer(new Position(ny, nx, ncnt));
            }
        }
    }

    static class Position implements Comparable<Position> {
        int y, x, cnt;

        Position (int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Position o){
            return this.cnt - o.cnt;
        }
    }
}
