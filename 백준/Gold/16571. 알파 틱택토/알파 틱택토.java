import java.io.*;
import java.util.*;

public class Main {
    static int[][] map = new int[3][3];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int zero = 0;
        for(int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0) zero++;
            }
        }

        int num = zero % 2 == 0 ? 2 : 1;
        int result = go(num);
        char ans;
        if(result == 1) ans = 'W';
        else if(result == 0) ans = 'D';
        else ans = 'L';

        System.out.print(ans);
    }

    static int go(int num) {
        int min = 2;

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = num;
                    if(isWin(num)) min = Math.min(min, -1);
                    min = Math.min(min , go(num == 1 ? 2 : 1));
                    map[i][j] = 0;
                }
            }
        }

        if(min == 1) return -1;
        else if(min == 0 || min == 2) return 0;
        else return 1;
    }

    static boolean isWin(int num) {
        for(int i = 0; i < 3; i++) {
            if(map[i][0] == num && map[i][0] == map[i][1] && map[i][1] == map[i][2]) return true;
        }

        for(int i = 0; i < 3; i++) {
            if(map[0][i] == num && map[0][i] == map[1][i] && map[1][i] == map[2][i]) return true;
        }

        if(map[1][1] == num && map[0][0] == map[1][1] && map[1][1] == map[2][2]) return true;
        if(map[1][1] == num && map[0][2] == map[1][1] && map[1][1] == map[2][0]) return true;

        return false;
    }
}
