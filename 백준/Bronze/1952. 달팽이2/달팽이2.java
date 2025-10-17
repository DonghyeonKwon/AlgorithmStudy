import java.io.*;
import java.util.*;

public class Main {

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        boolean[][] visited = new boolean[r][c];

        int y = 0, x = 0;
        int sum = 1;
        int cnt = 0;
        int d = 0;
        
        visited[y][x] = true;
        while(d < 4) {
            if(sum == r * c) break;
            
            int ny = y + dy[d];
            int nx = x + dx[d];
            if(0 <= nx && nx < c && 0 <= ny && ny < r && !visited[ny][nx]) {
                sum++;
                visited[ny][nx] = true;
                y = ny;
                x = nx;
            } else {
                cnt++;
                d++;
            }
            
            if(d >= 4) {
                d = 0;
            }
        }
        
        System.out.print(cnt);
    }
}
