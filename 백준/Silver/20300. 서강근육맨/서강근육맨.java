import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] arr = new long[n];

        for(int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        long max = 0L;
        for(int i = 0; i < n/2; i++) {
            max = Math.max(max, arr[i] + arr[((n % 2 == 0) ? n - 1: n - 2) - i]);
        }

        if(n % 2 == 0) {
            max = Math.max(max, arr[n-1]);
        }

        System.out.println(max);
    }
}
