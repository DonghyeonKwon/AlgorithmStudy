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

        int[] sums = new int[n * (n+1) / 2];
        int idx = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                sums[idx++] = arr[i] + arr[j];
            }
        }

        Arrays.sort(sums);
        int answer = -1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(binarySearch(sums, arr[i] - arr[j])) {
                    answer = Math.max(answer, arr[i]);
                }
            }
        }

        System.out.print(answer);
    }

    static boolean binarySearch(int[] arr, int k) {
        int l = 0;
        int r = arr.length - 1;

        while(l <= r) {
            int mid = (l + r) / 2;
            if(arr[mid] > k) {
                r = mid - 1;
            } else if(arr[mid] < k) {
                l = mid + 1;
            } else {
                return true;
            }

        }

        return false;
    }
}
