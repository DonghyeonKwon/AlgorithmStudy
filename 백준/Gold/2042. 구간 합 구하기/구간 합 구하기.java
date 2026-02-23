import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static long[] arr, fenwickTree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new long[n+1];
        fenwickTree = new long[n+1];

        for(int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(br.readLine());
            update(i, arr[i]);
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());

            int q = Integer.parseInt(st.nextToken());
            if(q == 1) {
                int b = Integer.parseInt(st.nextToken());
                long c = Long.parseLong(st.nextToken());
                update(b, c - arr[b]);
                arr[b] = c;
            } else {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                sb.append(sum(c) - sum(b - 1)).append('\n');
            }
        }

        System.out.print(sb);
    }

    static long sum(int pos) {
        long ret = 0;
        while(pos > 0) {
            ret += fenwickTree[pos];
            pos &= (pos - 1);
        }

        return ret;
    }

    static void update(int pos, long val) {
        while(pos <= n) {
            fenwickTree[pos] += val;
            pos += (pos & -pos);
        }
    }
}