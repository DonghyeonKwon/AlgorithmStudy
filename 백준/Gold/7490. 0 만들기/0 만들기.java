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

            dfs(1, new char[n]);
            if(t > 0)sb.append('\n');
        }

        System.out.print(sb);
    }

    static void dfs(int idx, char[] arr) {
        if(idx == n) {
            StringBuilder tmp = new StringBuilder();
            tmp.append(1);
            int num = 1;
            int prev = 1;
            char prevOper = '+';
            for(int i = 2; i <= n; i++) {
                tmp.append(arr[i-1]).append(i);
                if(arr[i-1] == ' ') {
                    if(prevOper == '+') {
                        num -= prev;
                    } else {
                        num += prev;
                    }
                    prev *= 10;
                    prev += i;
                    if(prevOper == '+') {
                        num += prev;
                    } else {
                        num -= prev;
                    }
                } else if(arr[i-1] == '+') {
                    num += i;
                    prev = i;
                    prevOper = '+';
                } else {
                    num -= i;
                    prev = i;
                    prevOper = '-';
                }
            }

            if(num == 0) {
                sb.append(tmp).append('\n');
            }

            return;
        }

        arr[idx] = ' ';
        dfs(idx+1, arr);
        arr[idx] = '+';
        dfs(idx+1, arr);
        arr[idx] = '-';
        dfs(idx+1, arr);
    }
}
