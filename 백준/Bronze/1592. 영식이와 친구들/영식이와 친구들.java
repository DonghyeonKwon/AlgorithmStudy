import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] cnt = new int[n+1];

        int idx = 1;
        int res = 0;
        while(true) {
            cnt[idx]++;

            if(cnt[idx] == m) break;

            res++;
            if(cnt[idx] % 2 == 1) {
                idx += l;
                if(idx > n) {
                    idx = (idx % n);
                }
            } else {
                idx -= l;
                if(idx < 1) {
                    idx = n + idx;
                }
            }
        }

        System.out.print(res);
    }
}
