import java.io.*;
import java.util.*;

public class Main {
    static long[] count = new long[10];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int start = 1;
        int digit = 1;

        while(start <= n) {

            while(n % 10 != 9 && start <= n) {
                count(n, digit);
                n--;
            }

            if(n < start) {
                break;
            }

            while(start % 10 != 0 && start <= n) {
                count(start, digit);
                start++;
            }

            start /= 10;
            n /= 10;

            for(int i = 0; i < 10; i++) {
                count[i] += (n - start + 1) * digit;
            }

            digit *= 10;
        }

        StringBuilder sb = new StringBuilder();
        for(long next : count) {
            sb.append(next).append(" ");
        }

        System.out.print(sb.toString().trim());
    }

    static void count(int num, int digit) {
        while(num > 0) {
            count[num % 10] += digit;
            num /= 10;
        }
    }
}
