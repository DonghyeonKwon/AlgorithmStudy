import java.io.*;
import java.util.*;

public class Main {
    static int n, ans = -1;
    static char[] input, result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        input = br.readLine().toCharArray();
        result = br.readLine().toCharArray();

        char[] temp = new char[n];
        for(int i = 0; i < n; i++) temp[i] = input[i];

        go(0, 1);
        if(ans == -1) {
            input = temp;
            input[0] = change(input[0]);
            input[1] = change(input[1]);
            go(1, 1);
        }

        System.out.print(ans);
    }

    static void go(int cnt, int x) {
        if(x == n) {
            if(input[x-1] == result[x-1]) {
                if(ans == -1) ans = cnt;
                else ans = Math.min(cnt, ans);
            }
            return;
        }

        if(input[x-1] == result[x-1]) go(cnt, x + 1);
        else {
            input[x-1] = change(input[x-1]);
            input[x] = change(input[x]);
            if(x + 1 != n) input[x+1] = change(input[x+1]);
            go(cnt + 1, x + 1);
        }
    }

    static char change(char c) {
        return c == '1' ? '0' : '1';
    }
}
