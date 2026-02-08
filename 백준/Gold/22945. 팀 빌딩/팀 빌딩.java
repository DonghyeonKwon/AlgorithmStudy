import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int l = 0;
        int r = n - 1;
        while(l < r) {
            int a = arr[l];
            int b = arr[r];

            int p = (r - l - 1) * Math.min(a, b);
            max = Math.max(max, p);

            if(a > b) {
                r--;
            } else {
                l++;
            }
        }

        System.out.print(max);
    }
}
