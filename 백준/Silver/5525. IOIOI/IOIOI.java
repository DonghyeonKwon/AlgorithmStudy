import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();

        int cnt = 0;
        for(int i = 0; i <= m - (2 * n + 1); i++) {
            if(arr[i] == 'I') {
                boolean flag = true;
                for(int j = 0; j < 2 * n + 1; j++) {
                    if(j % 2 == 0 && arr[i + j] == 'I') continue;
                    if(j % 2 == 1 && arr[i + j] == 'O') continue;
                    flag = false;
                    break;
                }

                if(flag) cnt++;
            }
        }

        System.out.print(cnt);
    }
}
