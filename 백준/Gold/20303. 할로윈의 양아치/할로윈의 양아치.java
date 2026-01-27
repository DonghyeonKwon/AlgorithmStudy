import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static int[] parent, arr, cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        arr = new int[n+1];
        cnt = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
            arr[i] = Integer.parseInt(st.nextToken());
            cnt[i] = 1;
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        boolean[] visited = new boolean[n+1];
        int[] dp = new int[k];
        for(int i = 1; i <= n; i++) {
            int p = find(i);
            if(visited[p]) continue;

            if(cnt[p] >= k) continue;
            for(int j = k-1; j >= cnt[p]; j--) {
                dp[j] = Math.max(dp[j], dp[j-cnt[p]] + arr[p]);
            }
            visited[p] = true;
        }

        System.out.print(dp[k-1]);
    }

    static int find(int x) {
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int aa = find(a);
        int bb = find(b);

        if(aa == bb) return;

        if(aa > bb) {
            int tmp = aa;
            aa = bb;
            bb = tmp;
        }

        parent[bb] = aa;
        cnt[aa] += cnt[bb];
        arr[aa] += arr[bb];
    }
}
