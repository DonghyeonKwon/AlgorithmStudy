import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String input = br.readLine();
            if(".".equals(input)) break;
            bw.write(getMaxKMP(input));

        }

        bw.flush();
        bw.close();
        br.close();
    }

    static String getMaxKMP(String str) {
        int j = 0;
        int len = str.length();
        int[] pi = new int[len];

        for(int i = 1; i < len; i++) {
            while(j > 0 && str.charAt(i) != str.charAt(j)) {
                j = pi[j - 1];
            }
            if(str.charAt(i) == str.charAt(j)) {
                pi[i] = ++j;
            }
        }

        int res = len % (len - pi[len-1]) != 0 ? 1 : len / (len - pi[len-1]);

        return res + "\n";
    }
}
