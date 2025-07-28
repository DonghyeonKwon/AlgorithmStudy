import java.io.*;
import java.util.*;

public class Main {

    static int n = 8;
    static char[][] map = new char[n][n];
    static Queue<int[]> q = new ArrayDeque<>(), temp = new ArrayDeque<>();

    static int[] dy = {0, -1, 0, 1, 0, -1, -1, 1, 1};
    static int[] dx = {0, 0, -1, 0, 1, 1, -1, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        q.add(new int[]{n-1, 0});

        int result = 1;
        while(true) {
            if(move()) break;
            if(temp.isEmpty()) {
                result = 0;
                break;
            }
            downWall();
            q = temp;
            temp = new ArrayDeque<>();
        }

        System.out.print(result);
    }

    static boolean move(){
        while(!q.isEmpty()) {
            int[] pos = q.poll();
            int y = pos[0];
            int x = pos[1];

            if(y == 0 && map[y][x] == '.') return true;
            if(map[y][x] == '#') continue;

            for(int i = 0; i < 9; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                if(map[ny][nx] == '#') continue;

                temp.add(new int[]{ny, nx});
            }
        }

        return false;
    }

    static void downWall(){
        char[] arr = new char[n];
        Arrays.fill(arr, '.');

        for(int i = n - 1; i > 0; i--) {
            map[i] = map[i-1];
        }
        map[0] = arr;
    }
}
