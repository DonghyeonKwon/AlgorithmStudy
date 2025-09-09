import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] sArr = new String[n];
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            sArr[i] = st.nextToken();
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        while(m-- > 0) {
            int num = Integer.parseInt(br.readLine());

            int l = 0;
            int r = n-1;

            int idx = 0;
            while(l <= r) {
                int mid = (l + r) / 2;

                if(num <= arr[mid]) {
                    r = mid - 1;
                    idx = mid;
                } else {
                    l = mid + 1;
                }
            }

            sb.append(sArr[idx]).append('\n');
        }

        System.out.print(sb);
    }
}
