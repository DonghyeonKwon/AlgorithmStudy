import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static String max = null, min = null;
    static char[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        arr = new char[k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        go(0, 0, new char[k+1]);
        System.out.print(max + "\n" + min);
    }

    static void go(int idx, int visited, char[] crr) {
        if(idx == k+1) {
            String num = String.valueOf(crr);

            if(max == null) {
                max = num;
                min = num;
                return;
            }

            if(max.compareTo(num) < 0) {
                max = num;
            }

            if(min.compareTo(num) > 0) {
                min = num;
            }

            return;
        }

        int i = 0;
        for(char c = '0'; i <= 9 && c <= '9'; i++, c++) {
            if((visited & (1 << i)) > 0) continue;
            if(idx == 0) {
                crr[idx] = c;
                go(idx + 1, visited | (1 << i), crr);
                continue;
            }

            if(arr[idx - 1] == '<' && crr[idx-1] > c) continue;
            if(arr[idx - 1] == '>' && crr[idx-1] < c) continue;
            crr[idx] = c;
            go(idx + 1, visited | (1 << i), crr);
        }
    }
}
