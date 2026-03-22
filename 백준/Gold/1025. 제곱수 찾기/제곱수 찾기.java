import java.io.*;
import java.util.*;

public class Main {
    static int n, m, len, max = -1;
    static char[][] map;
    static char[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];

        len = Math.max(n, m);
        arr = new char[len];
        Arrays.fill(arr, '.');

        for(int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for(int y = 0; y < n; y++) {
            for(int x = 0; x < m; x++) {
                go(y, x);
            }
        }

        System.out.print(max);
    }

    static void go(int y, int x) {
        for(int dy = -n; dy <= n; dy++) {
            for(int dx = -m; dx <= m; dx++) {
                if(dy == 0 && dx == 0) continue;
                dfs(y, x, dy, dx, 0);
            }
        }
    }

    static void dfs(int y, int x, int dy, int dx, int idx) {
        if(idx >= 1) {
            int num = arr[0] - '0';
            for(int i = 1; i < idx; i++) {
                num *= 10;
                num += arr[i] - '0';
            }
            check(num);
        }
        if(!isIn(y, x) || idx == len) return;

        arr[idx] = map[y][x];
        dfs(y + dy, x + dx, dy, dx, idx + 1);
        arr[idx] = '.';
    }

    static boolean isIn(int y, int x) {
        return 0 <= y && y < n && 0 <= x && x < m;
    }

    static void check(int num) {
        if(num == 0) {
            max = Math.max(max, num);
            return;
        }
        int k = (int)Math.sqrt(num);

        if(k == num / k && num % k == 0) {
            max = Math.max(max, num);
        }
    }
}
