import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        while(m != 1 || d > 7) {
            d -= 7;
            if(d <= 0) {
                m -= 1;
                if(m == 2) {
                    d += 28;
                } else if(m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
                    d += 31;
                } else {
                    d += 30;
                }
            }
        }

        if(d == 1) {
            System.out.print("MON");
        } else if(d == 2) {
            System.out.print("TUE");
        } else if(d == 3) {
            System.out.print("WED");
        } else if(d == 4) {
            System.out.print("THU");
        } else if(d == 5) {
            System.out.print("FRI");
        } else if(d == 6) {
            System.out.print("SAT");
        } else if(d == 7) {
            System.out.print("SUN");
        }
    }
}
