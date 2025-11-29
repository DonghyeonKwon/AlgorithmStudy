import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if(n == 1) {
            System.out.print(4);
            return;
        }

        long[] arr = new long[n];
        arr[0] = 1;
        arr[1] = 1;

        for(int i = 2; i < n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        System.out.print((arr[n-1] * 2 + arr[n-2]) * 2);
    }
}
