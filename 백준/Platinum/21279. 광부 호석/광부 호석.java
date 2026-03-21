import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static long[] cntTree;
    static long[] sumTree;
    static Map<Integer, List<int[]>> map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        cntTree = new long[400001];
        sumTree = new long[400001];
        map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            if(map.containsKey(x)) {
                map.get(x).add(new int[]{y, val});
            } else {
                List<int[]> list = new ArrayList<>();
                list.add(new int[]{y, val});
                map.put(x, list);
            }
        }

        long ans = 0;
        for(int i = 0; i <= 100000; i++) {
            if(map.containsKey(i)) {

                for(int[] arr : map.get(i)) {
                    update(1, 0, 100000, arr[0], arr[1]);
                }

                long totalSum = sumTree[1];
                long totalCnt = cntTree[1];


                if(totalCnt <= m) {
                    ans = Math.max(ans, totalSum);
                } else {
                    int pos = kth(1, 0, 100000, m + 1);
                    int h = pos - 1;

                    if(h >= 0) {
                        long sum = getSum(1, 0, 100000, 0, h);
                        ans = Math.max(sum, ans);
                    }
                }
                
            }
        }

        System.out.print(ans);
    }

    static void update(int node, int l, int r, int idx, int val) {
        if(idx < l || idx > r) return;

        if(l == r) {
            cntTree[node] += 1;
            sumTree[node] += val;
            return;
        }

        int mid = (l + r) / 2;
        update(node * 2, l, mid, idx, val);
        update(node * 2 + 1, mid + 1, r, idx, val);

        cntTree[node] = cntTree[node * 2] + cntTree[node * 2 + 1];
        sumTree[node] = sumTree[node * 2] + sumTree[node * 2 + 1];
    }

    static int kth(int node, int l, int r, long cnt) {
        if(l == r) return l;
        int mid = (l + r) / 2;
        long lCnt = cntTree[node * 2];
        if(cnt <= lCnt) return kth(node * 2, l, mid, cnt);
        else return kth(node * 2 + 1, mid + 1, r, cnt - lCnt);
    }

    static long getSum(int node, int l, int r, int ll, int rr) {
        if(rr < l || ll > r) return 0;
        if(ll <= l && r <= rr) return sumTree[node];
        int mid = (l + r) / 2;
        return getSum(node * 2, l, mid, ll, rr) + getSum(node * 2 + 1, mid + 1, r, ll, rr);
    }
}
