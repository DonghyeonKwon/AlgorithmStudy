import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int G = Integer.parseInt(br.readLine());

        long s = 1;
        long e = 2;
        boolean flag = false;
        while(s < 100000) {
            long ps = s * s;
            long pe = e * e;

            if(pe - ps == G) {
                sb.append(e).append('\n');
                flag = true;
            }

            if(pe - ps > G) {
                s++;
            } else {
                e++;
            }
        }

        System.out.print(flag ? sb : -1);
    }
}
