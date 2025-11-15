import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int len = 0;
        Arrays.fill(arr, -1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int b = Integer.parseInt(st.nextToken());
            int lower = lower_bound(arr, len, b);
            if(arr[lower] == -1) len++;
            arr[lower] = b;
        }

        System.out.print(len);
    }

    static int lower_bound(int[] arr, int len, int b) {
        int left = 0;
        int right = len;

        while(left < right) {
            int mid = (left + right) / 2;

            if(arr[mid] < b) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
