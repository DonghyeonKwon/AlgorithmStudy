import java.io.*;
import java.util.*;

public class Main {
    static int n, c;
    static List<int[]>[] listByX;

    static long[] segCnt = new long[400001];
    static long[] segSum = new long[400001];


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        listByX = new ArrayList[100001];
        for(int i = 0; i <= 100000; i++) listByX[i] = new ArrayList<>();

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            listByX[x].add(new int[]{y, v});
        }

        long ans = 0;

        for(int x = 0; x <= 100000; x++) {
            for(int[] p : listByX[x]) {
                int y = p[0];
                int v = p[1];
                update(1, 0, 100000, y, 1, v);
            }

            long totalCnt = segCnt[1];
            long totalSum = segSum[1];

            if(totalCnt <= c) {
                ans = Math.max(ans, totalSum);
            } else {
                int pos = kth(1, 0, 100000, c + 1);
                int h = pos - 1;

                if(h >= 0) {
                    long s = querySum(1, 0, 100000, 0, h);
                    ans = Math.max(ans, s);
                } else {
                    ans = Math.max(ans, 0);
                }
            }
        }

        System.out.print(ans);
    }

    static void update(int node, int l, int r, int idx, int cnt, int sum) {
        if(idx < l || r < idx) return;

        if(l == r) {
            segCnt[node] += cnt;
            segSum[node] += sum;
            return;
        }

        int mid = (l + r) / 2;
        update(node * 2, l, mid, idx, cnt, sum);
        update(node * 2 + 1, mid + 1, r, idx, cnt, sum);
        segCnt[node] = segCnt[node * 2] + segCnt[node * 2 + 1];
        segSum[node] = segSum[node * 2] + segSum[node * 2 + 1];
    }

    static int kth(int node, int l, int r, long k) {
        if(l == r) return l;
        int mid = (l + r) / 2;
        long leftCnt = segCnt[node * 2];
        if(k <= leftCnt) return kth(node * 2, l, mid, k);
        return kth(node * 2 + 1, mid + 1, r, k - leftCnt);
    }

    static long querySum(int node, int l, int r, int ql, int qr) {
        if(qr < l || ql > r) return 0;
        if(ql <= l && r <= qr) return segSum[node];
        int mid = (l + r) / 2;
        return querySum(node * 2, l, mid, ql, qr) + querySum(node * 2 + 1, mid + 1, r, ql, qr);
    }
}
