import java.io.*;
import java.util.*;

public class Main {
    static int n, m, cCnt;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> air = new ArrayDeque<>();
    static List<int[]> cheese = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                if(i == 0 || i == n-1 || j == 0 || j == m-1){
                    air.add(new int[]{i, j});
                }
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) cCnt++;
            }
        }

        int time = 0;

        while(true) {
            while(!air.isEmpty()){
                int[] pos = air.poll();

                for(int i = 0; i < 4; i++) {
                    int ny = pos[0] + dy[i];
                    int nx = pos[1] + dx[i];

                    if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                    if(visited[ny][nx]) continue;

                    if(map[ny][nx] == 1) {
                        cheese.add(new int[]{ny, nx});
                    } else {
                        visited[ny][nx] = true;
                        air.offer(new int[]{ny, nx});
                    }
                }
            }

            int cnt = 0;
            for(int[] pos : cheese) {
                if(map[pos[0]][pos[1]] == 1){
                    map[pos[0]][pos[1]] = 0;
                    air.offer(pos);
                    cnt++;
                }
            }
            
            if(cnt == 0) break;

            cCnt = cnt;
            time++;
        }

        bw.write(Integer.toString(time));
        bw.write('\n');
        bw.write(Integer.toString(cCnt));
        bw.flush();

        bw.close();
        br.close();
    }
}
