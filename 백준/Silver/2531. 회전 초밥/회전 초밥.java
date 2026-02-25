import java.io.*;
import java.util.*;

public class Main {
    static int n, d, k, c, ans = 1;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[n+k];

        for(int i = 0; i < n + k; i++) {
            if(i >= n) {
                arr[i] = arr[i- n];
            } else {
                arr[i] = Integer.parseInt(br.readLine());
            }
        }

        int[] kind = new int[d+1];
        int l = 0, r = 1;
        int kindCnt = 1;
        kind[arr[l]]++;

        while(r < n + k) {
            if(kind[arr[r]] == 0) {
                kind[arr[r++]]++;
                kindCnt++;
            } else {
                kind[arr[r++]]++;
            }

            if(r - l == k) {
                ans = Math.max(ans, kindCnt + (kind[c] == 0 ? 1 : 0));

                kind[arr[l]]--;
                if(kind[arr[l]] == 0) kindCnt--;
                l++;
            }
        }

        System.out.print(ans);
    }
}
