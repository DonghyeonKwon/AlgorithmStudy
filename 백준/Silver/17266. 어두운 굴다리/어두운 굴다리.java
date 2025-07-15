import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[] arr = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1;
        int right = n, answer = 1000000;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(go(arr, mid, n, m)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.print(answer);
    }

    static boolean go(int[] arr, int mid, int n, int m) {
        if(arr[0] - mid > 0) return false;

        int idx = 0;
        while(idx < m - 1) {
            if(arr[idx] + mid < arr[idx+1] - mid) return false;
            idx++;
        }
        

        return arr[idx] + mid >= n;
    }
}
