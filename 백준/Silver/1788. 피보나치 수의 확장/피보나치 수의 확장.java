import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int f0 = 0;
        int f1 = 1;
        int f2 = 0;
        int idx = 0;

        if(n == 0) {
            System.out.print("0\n0");
        } else if(n == 1) {
            System.out.print("1\n1");
        }
        else if(n < 0) {
            idx = -1;
            while(idx >= n) {
                f2 = f1 - f0;
                idx--;
                f1 = f0 % MOD;
                f0 = f2 % MOD;
            }
            System.out.println(f0 < 0 ? -1 : 1);
            System.out.println(Math.abs(f0));

        } else {
            idx = 2;

            while(idx <= n) {
                f2 = f1 + f0;
                idx++;
                f0 = f1 % MOD;
                f1 = f2 % MOD;
            }
            System.out.println(1 + "\n" + f1);
        }

    }
}
