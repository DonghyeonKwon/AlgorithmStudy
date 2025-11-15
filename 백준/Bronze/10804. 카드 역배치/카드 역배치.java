import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[21];
        for(int i = 1; i <= 20; i++) {
            arr[i] = i;
        }
        int T = 10;

        while(T --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int[] tmp = new int[b - a + 1];
            for(int i = a; i <= b; i++) {
                tmp[i - a] = arr[i];
            }

            for(int i = b; i >= a; i--) {
                arr[i] = tmp[b - i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= 20; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.print(sb);
    }
}
