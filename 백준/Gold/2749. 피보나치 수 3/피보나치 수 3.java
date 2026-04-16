import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        N %= 1500000;

        long[] fibo = new long[(int) N+1];
        fibo[0] = 0;
        fibo[1] = 1;

        for(int i = 2; i <= N; i++) {
            fibo[i] = (fibo[i-1] + fibo[i-2]) % 1000000;
        }

        System.out.print(fibo[(int) N]);
    }
}
