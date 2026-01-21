import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        int res = 0;
        boolean iced = true;

        while(A < B) {
            if(A < 0) {
                res += (-A * C);
                A = 0;
            } else if(A == 0 && iced) {
                res += D;
                iced = false;
            } else {
                res += (B - A) * E;
                A = B;
            }
        }

        System.out.print(res);
    }
}
