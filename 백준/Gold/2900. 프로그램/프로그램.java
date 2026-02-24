import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static Map<Integer, Integer> map = new HashMap<>();
    static long[] arr;
    static long[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new long[n+1];
        tree = new long[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int key : map.keySet()) {
            int num = map.get(key);
            for(int i = 0; i < n; i += key) {
                arr[i] += num;
            }
        }

        for(int i = 1; i <= n; i++) {
            init(i, arr[i-1]);
        }

        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int L = Integer.parseInt(st.nextToken()) + 1;
            int R = Integer.parseInt(st.nextToken()) + 1;

            sb.append(getSum(R) - getSum(L - 1)).append('\n');
        }

        System.out.print(sb);
    }

    static void init(int idx, long num) {
        while(idx <= n) {
            tree[idx] += num;
            idx += (idx & -idx);
        }
    }

    static long getSum(int idx) {
        long ret = 0;
        while(idx > 0) {
            ret += tree[idx];
            idx &= (idx - 1);
        }

        return ret;
    }
}
