import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static List<Integer>[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = 0;
        for(int i = 0; i < n; i++) {
            int p = Integer.parseInt(st.nextToken());
            if(p == -1) {
                root = i;
                continue;
            }
            arr[p].add(i);
        }

        k = Integer.parseInt(br.readLine());

        if(k == root) {
            System.out.print(0);
            return;
        }
        System.out.print(dfs(root));
    }

    static int dfs(int node) {
        int ret = 0;
        int child = 0;

        for(int next : arr[node]) {
            if(next == k) continue;
            ret += dfs(next);
            child++;
        }
        
        if(child == 0) return 1;
        return ret;
    }
}
