import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int bCnt = 0, rCnt = 0;

        char c = input.charAt(0);
        for(int i = 1; i < n; i++) {
            if(c != input.charAt(i)) {
                if(c == 'B') {
                    bCnt++;
                } else {
                    rCnt++;
                }
                c = input.charAt(i);
            }
        }

        if(c == 'B') {
            bCnt++;
        } else {
            rCnt++;
        }

        int min = Math.min(bCnt, rCnt);
        System.out.print(min + 1);

    }
}
