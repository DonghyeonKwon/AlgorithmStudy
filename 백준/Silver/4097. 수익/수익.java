import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            int n = Integer.parseInt(br.readLine());

            if(n == 0) break;
            long[] nrr = new long[n+1];

            long max = Long.MIN_VALUE;
            for(int i = 1; i <= n; i++) {
                int a = Integer.parseInt(br.readLine());
                nrr[i] = Math.max(nrr[i-1] + a, a);
                max = Math.max(max, nrr[i]);
            }

            sb.append(max).append('\n');
        }

        System.out.print(sb);
    }
}
