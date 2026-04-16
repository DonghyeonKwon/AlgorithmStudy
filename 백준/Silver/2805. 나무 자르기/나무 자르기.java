import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = 1000000000;
        int max = -1;
        while(left <= right) {
            int mid = (right + left) / 2;

            long sum = go(mid);
            if(m <= sum) {
                left = mid + 1;
                max = mid;
            } else {
                right = mid - 1;
            }
        }

        System.out.print(max);
    }

    static long go(int mid) {
        long sum = 0;
        for(int i = 0; i < n; i++) {
            if(mid < arr[i]) {
                sum += arr[i] - mid;
            }
        }

        return sum;
    }
}
