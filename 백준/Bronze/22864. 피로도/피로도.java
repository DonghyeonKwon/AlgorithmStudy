import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a, b, c, m, t = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        if(a > m) {
            System.out.print(0);
            return;
        }

        int sum = 0;
        for(int i = 0; i < 24; i++) {
            if(t + a > m) { //쉰다
                t -= c;
                if(t < 0) t = 0;
            } else { //일한다
                t += a;
                sum += b;
            }
        }

        System.out.print(sum);
    }
}
