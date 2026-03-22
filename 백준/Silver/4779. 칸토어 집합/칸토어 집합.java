import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num = "";
        while((num = br.readLine()) != null && !num.isEmpty()) {
            int n = Integer.parseInt(num);
            int k = 1;
            for(int i = 0; i < n; i++) k *= 3;
            go(k, '-');
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static void go(int n, char c) {
        if(n == 1) {
            sb.append(c);
            return;
        }

        if(c == ' ') {
            for(int i = 0; i < n; i++) {
                sb.append(' ');
            }
            return;
        }

        go(n/3, '-');
        go(n/3, ' ');
        go(n/3, '-');

    }
}
