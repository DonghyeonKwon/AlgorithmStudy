import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[] dy = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] ddy = {-1, -1, 1, 1};
    static int[] ddx = {-1, 1, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][N+1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<int[]> clouds = new ArrayList<>();
        clouds.add(new int[]{N,1});
        clouds.add(new int[]{N,2});
        clouds.add(new int[]{N-1,1});
        clouds.add(new int[]{N-1,2});

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            boolean[][] visited = new boolean[N+1][N+1];

            //이동
            s %= N;
            while(s-- > 0){
                for(int[] pos : clouds) {
                    pos[0] += dy[d];
                    pos[1] += dx[d];

                    if(pos[0] == 0) pos[0] = N;
                    if(pos[0] == N+1) pos[0] = 1;
                    if(pos[1] == 0) pos[1] = N;
                    if(pos[1] == N+1) pos[1] = 1;
                }
            }

            //비내리기
            for(int[] pos : clouds) {
                map[pos[0]][pos[1]]++;
                visited[pos[0]][pos[1]] = true;
            }

            //비복사
            for(int[] pos : clouds) {
                int y = pos[0];
                int x = pos[1];

                for(int i = 0; i < 4; i++) {
                    int ny = y + ddy[i];
                    int nx = x + ddx[i];

                    if(ny <= 0 || nx <= 0 || ny > N || nx > N) continue;
                    if(map[ny][nx] > 0) map[y][x]++;
                }
            }

            //물 제거
            List<int[]> tmp = new ArrayList<>();
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    if(visited[i][j]) continue;
                    if(map[i][j] >= 2) {
                        map[i][j] -= 2;
                        tmp.add(new int[]{i, j});
                    }
                }
            }

            clouds = tmp;
        }

        int sum = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                sum += map[i][j];
            }
        }

        System.out.println(sum);
    }
}
