import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n+1];
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        while(m-->0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if(s == 1) {
                for(int i = k; i <= n; i += k) arr[i] = arr[i] == 1 ? 0 : 1;
            } else {
                arr[k] = arr[k] == 1 ? 0 : 1;
                int i = 1;
                while(1 <= k - i && k + i <= n && arr[k+i] == arr[k-i]) {
                    arr[k-i] = arr[k-i] == 1 ? 0 : 1;
                    arr[k+i] = arr[k+i] == 1 ? 0 : 1;
                    i++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            sb.append(arr[i]).append(i % 20 == 0 ? '\n' : ' ');
        }
        System.out.print(sb);
    }
}
