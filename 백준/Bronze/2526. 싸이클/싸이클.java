import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[P+1][P+1];
        int tmp = (N * N) % P;
        while(true) {
            int a = (tmp * N) % P;
            if(map[tmp][a]) break;
            map[tmp][a] = true;
            tmp = a;
        }

        int k = tmp * N % P, cnt = 1;
        while(k != tmp) {
            int a = (k * N) % P;
            cnt++;
            k = a;
        }

        System.out.print(cnt);
    }
}
