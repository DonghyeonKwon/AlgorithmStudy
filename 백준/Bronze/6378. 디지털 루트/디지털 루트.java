import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String input = br.readLine();
            if(input.equals("0")) break;

            while(input.length() != 1) {
                input = go(input);
            }
            sb.append(input).append('\n');
        }

        System.out.print(sb);
    }

    static String go(String str) {
        int k = 0;

        for(int i = 0; i < str.length(); i++) {
            k += (str.charAt(i) - '0');
        }

        return String.valueOf(k);
    }
}
