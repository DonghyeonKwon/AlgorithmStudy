import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[][] answer = go(n);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(answer[i]);
            if(i != n-1) sb.append('\n');
        }

        System.out.print(sb);
    }

    static char[][] go(int n) {
        if(n == 3) {
            char[][] arr = {
                    {' ', ' ', '*', ' ', ' '},
                    {' ', '*', ' ', '*', ' '},
                    {'*', '*', '*', '*', '*'}
            };

            return arr;
        }

        int p = n/2;
        char[][] arr = go(n/2);
        char[][] tmp = new char[n][];

        for(int i = 0; i < n/2; i++) {
            char[] brr = new char[2*p + arr[i].length];
            for(int j = 0; j < n/2; j++) {
                brr[j] = ' ';
            }
            for(int j = p; j < p + arr[i].length; j++) {
                brr[j] = arr[i][j-p];
            }
            for(int j = p + arr[i].length; j < 2 * p + arr[i].length; j++) {
                brr[j] = ' ';
            }

            tmp[i] = brr;
        }

        p = 1;
        for(int i = n/2; i < n; i++) {
            int len = arr[i - n/2].length;
            char[] brr = new char[p + 2 * len];
            for(int j = 0; j < len; j++) {
                brr[j] = arr[i - n/2][j];
            }
            brr[len] = ' ';
            for(int j = len + p; j<  p + 2 * len; j++) {
                brr[j] = arr[i - n/2][j - len - p];
            }
            tmp[i] = brr;
        }

        return tmp;
    }
}
