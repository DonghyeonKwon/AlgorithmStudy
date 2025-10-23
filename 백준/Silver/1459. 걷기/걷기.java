import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        long sum1 = (long)(x + y) * w;
        long sum2 = (long)Math.min(x, y) * s + (long) Math.abs(x - y) * w;
        long sum3 = (long)Math.min(x, y) * s + ((long) Math.abs(x - y) % 2 == 0 ? (long) Math.abs(x - y) * s : (long) (Math.abs(x - y) - 1) * s + w);

        System.out.print(Math.min(Math.min(sum1, sum2), sum3));
    }
}
