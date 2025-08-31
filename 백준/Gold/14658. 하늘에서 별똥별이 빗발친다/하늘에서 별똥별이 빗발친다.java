import java.io.*;
import java.util.*;

public class Main {
    static int n, m, l, k;
    static Star[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new Star[k];
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Star(x, y);
        }

        int res = 0;
        for(Star a : arr) {
            for(Star b : arr) {
                res = Math.max(res, check(a.x, b.y, l));
            }
        }

        System.out.print(k - res);
    }

    static int check(int i, int j, int l) {
        int cnt = 0;

        for(Star s : arr) {
            if(s.x >= i && s.x <= i + l && j <= s.y && s.y <= j + l) {
                cnt++;
            }
        }

        return cnt;
    }

    static class Star {
        int x, y;

        Star(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
