import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int zeroCnt = 0;
        int oneCnt = 0;

        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '0') {
                zeroCnt++;
            } else {
                oneCnt++;
            }
        }

        int oneTmp = oneCnt/2;
        int zeroTmp = zeroCnt/2;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '0') {
                if(zeroTmp <= 0) continue;
                sb.append(0);
                zeroTmp--;
            } else {
                if(oneTmp > 0) {
                    oneTmp--;
                    continue;
                }
                sb.append(1);
            }
        }

        System.out.print(sb);
    }
}
