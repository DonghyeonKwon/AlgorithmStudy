import java.io.*;
import java.util.*;

public class Main {
    static int[] inorder, inIdx, postorder;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        inorder = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
        }

        postorder = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        inIdx = new int[n+1];
        for(int i = 1; i <= n; i++) {
            inIdx[inorder[i]] = i;
        }

        solve(1, n, 1, n);
        System.out.println(sb);
    }

    static void solve(int is, int ie, int ps, int pe) {
        if(ie < is || pe < ps) return;
        int root = postorder[pe];
        int rIdx = inIdx[root];
        sb.append(root+ " ");

        int len = rIdx - is;
        solve(is, rIdx - 1, ps, ps + len - 1);
        solve(rIdx + 1, ie, ps + len, pe - 1);
    }
}
