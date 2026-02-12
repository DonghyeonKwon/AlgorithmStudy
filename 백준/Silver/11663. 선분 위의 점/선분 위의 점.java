import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int low = check(n, arr, l);
            int high = check(n, arr, r);

            int cnt = high - low + 1;
            int down = 0;
            if(r < arr[high]) {
                cnt -= 1;
                down += 1;
            }

            if(l > arr[low]) {
                cnt -= 1;
                down += 1;
            }

            if(down == 2 && low == high) cnt += 1;

            sb.append(cnt).append('\n');
        }

        System.out.print(sb);
    }

    static int check(int n, int[] arr, int num) {

        int l = 0;
        int r = n-1;
        int rtn = 0;
        while(l <= r) {
            int mid = (l + r) / 2;

            if(arr[mid] <= num) {
                l = mid + 1;
                rtn = mid;
            } else {
                r = mid - 1;
            }
        }

        return rtn;
    }
}
