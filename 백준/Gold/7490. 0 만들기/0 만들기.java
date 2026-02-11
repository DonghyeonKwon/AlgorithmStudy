import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while(t-->0) {
            n = Integer.parseInt(br.readLine());

            dfs(2, 1, 1, '+', new char[n]);
            if(t > 0)sb.append('\n');
        }

        System.out.print(sb);
    }

    static void dfs(int idx, int num, int prev, char prevOper, char[] operArr) {
        if(idx == n+1) {
            if(num != 0) return;
            StringBuilder tmp = new StringBuilder();
            tmp.append(1);

            for(int i = 2; i <= n; i++) {
                tmp.append(operArr[i-1]).append(i);
            }
            sb.append(tmp).append('\n');

            return;
        }

        //' '
        int tmp = num;
        int tmpPrev = prev;
        operArr[idx-1] = ' ';
        if(prevOper == '+') {
            tmp -= prev;
        } else {
            tmp += prev;
        }
        tmpPrev *= 10;
        tmpPrev += idx;
        if(prevOper == '+') {
            tmp += tmpPrev;
        } else {
            tmp -= tmpPrev;
        }
        dfs(idx+1, tmp, tmpPrev, prevOper, operArr);

        //'+'
        operArr[idx-1] = '+';
        dfs(idx+1, num + idx, idx, '+', operArr);

        operArr[idx-1] = '-';
        dfs(idx+1, num - idx, idx, '-', operArr);
    }
}
