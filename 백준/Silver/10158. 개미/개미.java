import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());

        int t = Integer.parseInt(br.readLine());

        int p = (sx + t) % (2 * w);
        int q = (sy + t) % (2 * h);
        if(p > w) p = 2 * w - p;
        if(q > h) q = 2 * h - q;
        System.out.println(p + " " + q);
    }

}
