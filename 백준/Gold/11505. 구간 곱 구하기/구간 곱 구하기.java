import java.io.*;
import java.util.*;

public class Main {

    static int MOD = 1000000007;
    static long[] arr, tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new long[n+1];
        for(int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        tree = new long[n * 4];
        init(1, n, 1);

        for(int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1) {
                arr[b] = c;
                update(1, n, 1, b, c);
            } else {
                sb.append(mul(1, n, 1, b, (int) c)).append("\n");
            }
        }

        System.out.print(sb);

    }

    static long init(int start, int end, int node) {
        if(start == end) {
            return tree[node] = arr[start];
        }

        int mid = (start + end) / 2;
        return tree[node] = (init(start, mid, node * 2) * init(mid+1, end, node * 2 + 1)) % MOD;
    }

    static long update(int start, int end, int node, int idx, long val) {
        if(idx < start || idx > end) {
            return tree[node];
        }

        if(start == end) {
            return tree[node] = val;
        }

        int mid = (start + end) / 2;
        return tree[node] = (update(start, mid, node * 2, idx, val) * update(mid + 1, end, node * 2 + 1, idx, val)) % MOD;
    }

    static long mul(int start, int end, int node, int left, int right) {
        if(left > end || right < start) {
            return 1;
        }

        if(left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return (mul(start, mid, node * 2, left, right) * mul(mid + 1, end, node * 2 + 1, left, right)) % MOD;
    }
}
