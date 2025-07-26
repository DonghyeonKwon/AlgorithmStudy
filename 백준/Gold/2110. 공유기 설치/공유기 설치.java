import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        int max = -1;
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        Arrays.sort(arr);

        int left = 0;
        int right = max;
        int result = -1;
        while(left <= right) {
            int mid = (left + right) / 2;

            int cnt = go(mid);
            if(cnt >= k) {
                left = mid + 1;
                result = mid;
            } else {
                right = mid - 1;
            }
        }

        System.out.print(result);
    }

    static int go(int mid) {
        int cnt = 1;
        int start = arr[0];
        for(int i = 1; i < n; i++) {
            if(arr[i] < start + mid) continue;
            start = arr[i];
            cnt++;
        }
        return cnt;
    }
}
