import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringBuilder sb = new StringBuilder();
        int k = 1;
        for(int i = input.length() - 1; i >= 0; i -= 3) {
            int p1 = input.charAt(i) - '0';
            int p2 = i - 1 < 0 ? 0 : input.charAt(i-1) - '0';
            int p3 = i - 2 < 0 ? 0 : input.charAt(i-2) - '0';
            sb.append((p1 * 1 + p2 * 2 + p3 * 4));
        }

        sb.reverse();
        System.out.print(sb);
    }
}
