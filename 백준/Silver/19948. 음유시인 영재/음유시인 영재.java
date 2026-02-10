import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[27];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 26; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[26] = n;

        char prevChar = '0';
        char titlePrevChar = '0';
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(prevChar == c) continue;

            int idx = getIndex(c);
            if(arr[idx] <= 0) {
                flag = false;
                break;
            }
            arr[idx] -= 1;

            if(i == 0 || input.charAt(i-1) == ' ') {
                char cc = (char) ('A' + idx);
                if(titlePrevChar != cc) {
                    if(arr[idx] <= 0) {
                        flag = false;
                        break;
                    }
                    arr[idx] -= 1;
                    titlePrevChar = cc;
                }
                sb.append(cc);
            }

            prevChar = c;
        }

        System.out.print(flag ? sb : -1);
    }

    static int getIndex(char c) {
        if('A' <= c && c <= 'Z') return c - 'A';
        if('a' <= c && c <= 'z') return c - 'a';
        return 26;
    }
}
