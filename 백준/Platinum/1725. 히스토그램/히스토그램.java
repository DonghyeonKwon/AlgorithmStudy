import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static int[] tree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        tree = new int[4 * n];

        long ans = 0;
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            ans = Math.max(ans, arr[i]);
        }

        dfs(1, n, 1);

        System.out.print(area(1, n));
    }

    static int find(int start, int end, int node, int left, int right) {
        if(start > right || end < left) return  -1;
        if(left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;
        int ll = find(start, mid, node * 2, left, right);
        int rr = find(mid+1, end, node * 2 + 1, left, right);

        if(ll == -1) return rr;
        else if(rr == -1) return ll;
        else if(arr[ll] <= arr[rr]) {
            return ll;
        }

        return rr;
    }

    static int area(int left, int right) {
        if(left == right) return arr[left];

        int idx = find(1, n, 1, left, right);
        int wide = (right - left + 1) * arr[idx];
        if(left <= idx - 1) wide = Math.max(wide, area(left, idx - 1));
        if(idx + 1 <= right) wide = Math.max(wide, area(idx + 1, right));

        return wide;
    }

    static int dfs(int left, int right, int node) {
        if(left > right) return Integer.MAX_VALUE;

        if(left == right) {
            tree[node] = left;
            return tree[node];
        }
        int mid = (left + right) / 2;
        int ll = dfs(left, mid, node * 2);
        int rr = dfs(mid + 1, right, node * 2 + 1);

        if(arr[ll] <= arr[rr]) {
            tree[node] = ll;
        } else {
            tree[node] = rr;
        }

        return tree[node];
    }
}
