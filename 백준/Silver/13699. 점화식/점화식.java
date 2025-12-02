import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n+1];

        arr[0] = 1;

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                arr[i] += arr[j] * arr[i - j - 1];
            }
        }

        System.out.print(arr[n]);
    }
}
