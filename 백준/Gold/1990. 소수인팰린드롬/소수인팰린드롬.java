import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[b+1];
        arr[0] = true;
        arr[1] = true;

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= b; i++) {
            if(arr[i]) continue;

            if(i >= a && check(i)) sb.append(i).append('\n');
            for(int j = i + i; j <= b; j += i) {
                arr[j] = true;
            }
        }
        sb.append(-1);

        System.out.print(sb);
    }

    static boolean check(int num) {
        String str = String.valueOf(num);

        int l = 0;
        int r = str.length() - 1;

        while(l <= r) {
            if(str.charAt(l) != str.charAt(r)) return false;
            l++;
            r--;
        }

        return true;
    }
}
