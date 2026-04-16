import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        System.out.print(go(n, m));
    }

    static BigInteger f(int x) {
        BigInteger p = new BigInteger("1");
        for(int i = 1; i <= x; i++) {
            p = p.multiply(new BigInteger(String.valueOf(i)));
        }

        return p;
    }

    static BigInteger go(int n, int m) {
        return f(n).divide(f(m).multiply(f(n-m)));
    }
}
