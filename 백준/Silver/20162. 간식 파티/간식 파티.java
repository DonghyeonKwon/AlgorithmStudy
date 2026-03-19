import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int res = 0;
        int[] dp = Arrays.copyOf(arr, n);
        for(int i = 0; i < n; i++) {
            res = Math.max(res, arr[i]);
            for(int j = i + 1; j < n; j++) {
                if(arr[i] < arr[j] && dp[i] + arr[j] > dp[j]) {
                    dp[j] = dp[i] + arr[j];
                    res = Math.max(res, dp[j]);
                }
            }
        }

        System.out.print(res);
    }
}
