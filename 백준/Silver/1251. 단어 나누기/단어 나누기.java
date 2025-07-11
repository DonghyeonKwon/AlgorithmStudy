import java.io.*;
import java.util.*;

public class Main {
    static String res = null;
    static int n;
    static char[] input;
    static int[] select = new int[3];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine().toCharArray();
        n = input.length;

        go(0, 0);

        System.out.println(res);
    }

    static void go(int idx, int cnt) {
        if(cnt < 3 && idx >= n) return;

        if(cnt == 3) {
            StringBuilder sb = new StringBuilder();

            sb.append(word(0, select[0]));
            sb.append(word(select[0]+1, select[1]));
            sb.append(word(select[1]+1, n-1));
            if(res == null) {
                res = String.valueOf(sb);
            } else {
                res = res.compareTo(sb.toString()) > 0 ? sb.toString() : res;
            }

            return;
        }

        for(int i = idx; i <= n; i++) {
            select[cnt] = i;
            go(i+1, cnt+1);
        }
    }

    static String word(int i, int k) {
        StringBuilder sb = new StringBuilder();

        for(; i <= k; i++) {
            sb.append(input[i]);
        }

        return sb.reverse().toString();
    }
}
