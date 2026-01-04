import java.io.*;
import java.util.*;

public class Main {

    static int tmpAns;
    static int[] tmp, arr;
    static int[] dy = {0, -1, 0, 1, 0};
    static int[] dx = {0, 0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[10];
        tmp = new int[10];

        for(int i = 0; i < 10; i++) {
            int num = 0;
            String input = br.readLine();
            for(int j = 0; j < 10; j++) {
                num |= input.charAt(j) == 'O' ? (1 << j) : 0;
            }
            arr[i] = num;
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < (1 << 10); i++) {
            init();

            for(int j = 0; j < 10; j++) {
                int num = 1 << j;
                if((i & num) > 0) {
                    tmpAns++;
                    click(0, j);
                }
            }

            for(int j = 1; j < 10; j++) {
                for(int k = 0; k < 10; k++) {
                    if((tmp[j-1] & (1 << k)) > 0) {
                        tmpAns++;
                        click(j, k);
                    }
                }
            }

            if(tmp[9] == 0) {
                ans = Math.min(ans, tmpAns);
            }
        }

        System.out.print(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    static void click(int y, int x) {
        for(int i = 0; i < 5; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if(ny < 0 || nx < 0 || ny >= 10 || nx >= 10) continue;
            tmp[ny] ^= (1 << nx);
        }
    }

    static void init() {
        tmpAns = 0;
        for(int i = 0; i < 10; i++) {
            tmp[i] = arr[i];
        }
    }
}
