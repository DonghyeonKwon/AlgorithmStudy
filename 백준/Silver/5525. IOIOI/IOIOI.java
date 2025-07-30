import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();

        int ans = 0;
        int cnt = 0;
        for(int i = 0; i < m - 2; i++) {
            if(arr[i] == 'I' && arr[i+1] == 'O' && arr[i+2] == 'I') {
                cnt++;
                i++;
                if(cnt == n) {
                    cnt--;
                    ans++;
                }
            } else {
                cnt = 0;
            }
        }

        System.out.print(ans);
    }
}
