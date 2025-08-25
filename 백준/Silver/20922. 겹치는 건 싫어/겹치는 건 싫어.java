import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0, r = 0, max = 0;
        int[] cnt = new int[100001];
        while(l < n && r < n) {
            if(cnt[arr[r]] < k) {
                cnt[arr[r]]++;
                r++;
            } else {
                cnt[arr[l]]--;
                l++;
            }

            max = Math.max(max, r - l);
        }

        System.out.print(max);
    }
}
