import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int idx = 0;
        long sum = 0;
        long lCnt = 0;
        long rCnt = 0;
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(num % 2 == 0) {
                sum += idx++;
                lCnt += i;
                rCnt += n - 1 - i;
            }
        }

        System.out.print(Math.min(lCnt, rCnt) - sum);

    }
}
