import java.io.*;
import java.util.*;

public class Main {
    static Map<Long, Long> dp;
    static long n, p, q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Long.parseLong(st.nextToken());
        p = Long.parseLong(st.nextToken());
        q = Long.parseLong(st.nextToken());

        dp = new HashMap<>();
        dp.put(n, go(n));

        System.out.print(dp.get(n));
    }

    static long go(long num) {
        if(num == 0) return 1L;

        long pRes = 0;
        if(dp.containsKey(num/p)) {
            pRes = dp.get(num/p);
        } else {
            pRes = go(num/p);
            dp.put(num/p, pRes);
        }

        long qRes = 0;
        if(dp.containsKey(num/q)) {
            qRes = dp.get(num/q);
        } else {
            qRes = go(num/q);
            dp.put(num/q, qRes);
        }

        return pRes + qRes;
    }
}
