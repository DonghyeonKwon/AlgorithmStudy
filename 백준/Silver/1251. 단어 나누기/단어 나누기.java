import java.io.*;
import java.util.*;

public class Main {
    static String ans = null;
    static String input;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();

        dfs(0,  0, new int[2]);

        System.out.print(ans);
    }

    static void dfs(int idx, int cnt, int[] arr) {
        if(idx >= input.length() && cnt <= 2) return;

        if(cnt == 2) {
            StringBuilder sb = new StringBuilder();
            for(int i = arr[0]; i >= 0; i--) {
                sb.append(input.charAt(i));
            }

            for(int i = arr[1]; i > arr[0]; i--) {
                sb.append(input.charAt(i));
            }

            for(int i = input.length() - 1; i > arr[1]; i--) {
                sb.append(input.charAt(i));
            }

            if(ans == null) {
                ans = sb.toString();
            } else {
                ans = ans.compareTo(sb.toString()) > 0 ? sb.toString() : ans;
            }

            return;
        }

        for(int i = idx; i < input.length(); i++) {
            arr[cnt] = i;
            dfs(i + 1, cnt + 1, arr);
        }
    }
}
