import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[m + 1];

        int n = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            n += arr[i];
        }
        int k = Integer.parseInt(br.readLine());

        if(k == 1) {
            System.out.print("1.0");
            return;
        }

        double answer = 0.0;
        for(int i = 1; i <= m; i++) {
            if(arr[i] < k) continue;

            double prod  = 1.0;
            for(int j = 0; j < k; j++) {
                prod *= (double) (arr[i] - j) / (double)(n - j);
            }

            answer += prod;
        }

        System.out.print(answer);
    }

    static long f(int p, int k) {
        long u = 1;
        long d = 1;
        k = Math.min(p - k, k);
        for(int i = k; i >= 1; i--) {
            u *= p;
            p -= 1;
            d *= i;
        }
        return u / d;
    }
}
