import java.io.*;
import java.util.*;

public class Main {
    static int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if(n == 0) {
            System.out.print(0); return;
        }
        int a = 0;
        int b = 1;
        int c = 1;
        int idx = 1;
        while(idx < n) {
            c = (b + a) % MOD;
            a = b;
            b = c;
            idx++;
        }

        System.out.print(c);
    }
}
