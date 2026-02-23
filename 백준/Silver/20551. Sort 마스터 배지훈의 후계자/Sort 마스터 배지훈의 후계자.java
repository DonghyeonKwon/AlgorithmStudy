import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(br.readLine());

            int l = 0;
            int r = n - 1;
            int ans = -1;

            while(l <= r) {
                int mid = (l + r) / 2;

                if(arr[mid] >= num) {
                    if(arr[mid] == num) ans = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            sb.append(ans).append('\n');
        }

        System.out.print(sb);
    }
}
