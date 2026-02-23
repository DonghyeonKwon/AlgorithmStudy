import java.io.*;
import java.util.*;

public class Main {
    static int s, N, K, r1, r2, c1, c2, p, len;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        s = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        r1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c1 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());
        p = (N - K) / 2;
        len = (int)Math.pow(N, s);

        StringBuilder sb = new StringBuilder();
        for(int y = r1; y <= r2; y++) {
            for(int x = c1; x <= c2; x++) {
                sb.append(getColor(y, x));
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static int getColor(int y, int x) {
        int size = len;

        while(size > 1) {
            int ds = size / N;

            int ny = y / ds;
            int nx = x / ds;

            if(p <= ny && ny < p + K && p <= nx && nx < p + K) return 1;

            y %= ds;
            x %= ds;
            size = ds;
        }

        return 0;
    }
}
