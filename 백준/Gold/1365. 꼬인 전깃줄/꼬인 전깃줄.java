import java.io.*;
import java.util.*;

public class Main {

    static int[] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        dp = new int[n+1];
        Arrays.fill(arr, -1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int idx = 0;
        int len = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] > dp[len]) {
                len += 1;
                dp[len] = arr[i];
                continue;
            }

            idx = lowerBound(0, len, arr[i]);
            dp[idx] = arr[i];
        }
        System.out.print(n - len);
    }

    static int lowerBound(int left, int right, int b) {

        while(left < right) {
            int mid = (left + right) / 2;

            if(dp[mid] <= b) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }
}
