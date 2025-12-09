import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            String input = br.readLine();
            String result = br.readLine();

            int cntB = 0;
            int cntW = 0;

            for(int i = 0; i < n; i++) {
                if(input.charAt(i) != result.charAt(i)) {
                    if(input.charAt(i) == 'B') {
                        cntB++;
                    } else {
                        cntW++;
                    }
                }
            }

            sb.append(Math.min(cntB, cntW) + Math.abs(cntB - cntW)).append('\n');
        }

        System.out.print(sb);
    }
}
