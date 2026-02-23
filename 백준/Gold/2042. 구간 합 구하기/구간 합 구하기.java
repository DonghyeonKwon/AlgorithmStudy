import java.io.*;
import java.util.*;

public class Main {
    static long[] arr;
    static long[] segTree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new long[n+1];
        segTree = new long[4*n + 1];
        for(int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        init(1, n, 1);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());

            int q = Integer.parseInt(st.nextToken());

            if(q == 1) {
                int a = Integer.parseInt(st.nextToken());
                long b = Long.parseLong(st.nextToken());
                long val = b - arr[a];
                arr[a] = b;
                update(1, n, 1, a, val);
            } else {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                sb.append(get(1, n, 1, a, b)).append('\n');
            }
        }

        System.out.print(sb);
    }

    static long get(int l, int r, int node, int s, int e) {
        if(e < l || s > r) return 0;
        if(s <= l && r <= e) return segTree[node];

        int mid = (l + r) / 2;
        return get(l, mid, node * 2, s, e) + get(mid + 1, r, node * 2 + 1, s, e);
    }

    static void update(int l, int r, int node, int target, long value) {
        if(target < l || target > r) return;

        segTree[node] += value;

        if(l == r) return;

        int mid = (l + r) / 2;
        update(l, mid, node * 2, target, value);
        update(mid + 1, r, node * 2 + 1, target, value);
    }

    static void init(int l, int r, int node) {
        if(r < l) return;

        if(l == r) {
            segTree[node] = arr[l];
            return;
        }

        int mid = (l + r) / 2;
        init(l, mid, node * 2);
        init(mid + 1, r, node * 2 + 1);

        segTree[node] = segTree[node * 2] + segTree[node * 2 + 1];
    }
}
