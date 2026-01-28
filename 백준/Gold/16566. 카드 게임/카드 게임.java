import java.io.*;
import java.util.*;

public class Main {
    static int n, m, k;
    static int[] card;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        card = new int[n+1];
        for(int i = 1; i <= n; i++) {
            card[i] = i + 1;
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            card[num] = num;
        }
        card[n] = n;

        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < k; i++) {
            int num = Integer.parseInt(st.nextToken());

            int l = num + 1;
            int r = n;
            int ans = -1;
            while(l <= r) {
                int mid = (l + r) / 2;

                int p = find(mid);
                if(p > num) {
                    r = mid - 1;
                    ans = p;
                } else {
                    l = mid + 1;
                }
            }

            card[ans] += 1;
            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }

    static int find(int x) {
        if(x == card[x]) {
            return x;
        }
        return card[x] = find(card[x]);
    }
}
