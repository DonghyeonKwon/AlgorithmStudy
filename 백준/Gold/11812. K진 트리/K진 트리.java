import java.io.*;
import java.util.*;

public class Main {
    static long n;
    static int k, q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

       for(int i = 0; i < q; i++) {
           st = new StringTokenizer(br.readLine());
           long x = Long.parseLong(st.nextToken());
           long y = Long.parseLong(st.nextToken());
           if (k == 1) {
               sb.append(Math.abs(x - y) + "\n");
           } else {
               sb.append(search(x, y) + "\n");
           }
       }

       System.out.print(sb);
    }

    static long search(long x, long y) {
        long mv = 0;
        long xh = getDepth(x);
        long yh = getDepth(y);

        if(xh < yh) {
            long tmp = x;
            x = y;
            y = tmp;
            long tTmp = xh;
            xh = yh;
            yh = tTmp;
        }

        while(xh != yh) {
            x = getParent(x);
            xh = getDepth(x);
            mv++;
        }

        while(x != y) {
            x = getParent(x);
            y = getParent(y);
            mv += 2;
        }

        return mv;
    }

    static long getParent(long idx) {
        return (idx - 2) / k + 1;
    }

    static long getDepth(long idx) {
        if(idx == 1) return 0;
        long line = 1;
        long h = 1;
        while(true) {
            line += (long)Math.pow(k, h++);
            if(idx <= line) break;
        }
        return h-1;
    }
}
