import java.io.*;
import java.util.*;

public class Main {
    static List<long[]> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long C = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());

            list.add(new long[]{A, C, B});
            min = Math.min(min, A);
            max = Math.max(max, C);
        }
        max++;

        long l = min;
        long r = max;
        while(l < r) {
            long mid = (l + r) / 2;
            
            long cnt = check(mid);
            if(cnt % 2 == 1) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        if(l == max) {
            System.out.print("NOTHING");
        } else {
            long res = check(l) - check(l - 1);

            System.out.print(l + " " + res);
        }
    }

    static long check(long mid) {
        long cnt = 0;
        for(long[] arr : list) {
            long A = arr[0];
            long C = arr[1];
            long B = arr[2];

            if(A > mid) continue;

            cnt += (Math.min(C, mid) - A) / B + 1;
        }

        return cnt;
    }
}
