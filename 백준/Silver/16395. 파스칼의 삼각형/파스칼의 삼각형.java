import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()) - 1;
        int k = Integer.parseInt(st.nextToken()) - 1;

        if(n - k < k) {
            k = n - k;
        }

        long a = 1;
        long b = 1;
        for(int i = 1; i <= k; i++) {
            a *= n;
            b *= i;
            n--;
        }

        System.out.print(a / b);
    }
}
