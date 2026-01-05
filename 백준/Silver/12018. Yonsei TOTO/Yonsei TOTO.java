import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        for(int t = 0; t < n; t++) {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int[] brr = new int[p];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < p; i++) {
                brr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(brr);

            if(p - l >= 0) {
                arr[t] = brr[p-l];
            } else {
                arr[t] = 1;
            }
        }

        Arrays.sort(arr);
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(m - arr[i] < 0) break;
            cnt++;
            m -= arr[i];
        }

        System.out.print(cnt);
    }
}
