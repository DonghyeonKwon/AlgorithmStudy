import java.io.*;
import java.util.*;

public class Main {
    static int n, k, x;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }

        int left = 1;
        int right = n;
        int ans = -1;
        while(left <= right) {
            int mid = (left + right) / 2;
            
            if(check(mid) && n - mid > 0) {
                left = mid + 1;
                ans = Math.max(ans, mid);
            } else {
                right = mid - 1;
            }
        }

        System.out.print(ans);
    }

    static boolean check(int dd) {
        for(int i = 1; i <= n - dd + 1; i++) {
            int sum = 0;

            sum += arr[i-1] * x;
            sum += arr[n] - arr[i + dd - 1];

            if(sum >= k) {
                return true;
            }
        }

        return false;
    }
}
