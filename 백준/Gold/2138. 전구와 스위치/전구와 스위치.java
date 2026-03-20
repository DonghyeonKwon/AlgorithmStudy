import java.io.*;
import java.util.*;

public class Main {
    static int n, res = -1;
    static char[] input, result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        input = br.readLine().toCharArray();
        result = br.readLine().toCharArray();

        char[] tmp = Arrays.copyOf(input, n);

        go(1, 0);
        if(res == -1) {
            input = tmp;
            input[0] = change(input[0]);
            input[1] = change(input[1]);
            go(1, 1);
        }

        System.out.print(res);
    }

    static void go(int idx, int cnt) {
        if(idx == n) {
            if(input[idx - 1] != result[idx - 1]) return;
            if(res == -1) res = cnt;
            if(res > cnt) res = cnt;
            return;
        }

        if(input[idx - 1] != result[idx - 1]) {
            input[idx - 1] = change(input[idx-1]);
            input[idx] = change(input[idx]);
            if(idx + 1 < n) input[idx + 1] = change(input[idx + 1]);
            go(idx + 1, cnt + 1);
        } else {
            go(idx + 1, cnt);
        }
    }

    static char change(char c) {
        return c == '0' ? '1' : '0';
    }
}
