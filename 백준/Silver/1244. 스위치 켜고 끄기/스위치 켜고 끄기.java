import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if(s == 1) {
                for(int j = num; j <= n; j += num){
                    arr[j] ^= 1;
                }
            } else {
                int k = 1;
                arr[num] ^= 1;
                while(true) {
                    if(num - k < 1 || num + k > n) break;
                    if(arr[num - k] == arr[num + k]) {
                        arr[num-k] ^= 1;
                        arr[num+k] ^= 1;
                        k++;
                    } else {
                        break;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            sb.append(arr[i]).append(i % 20 == 0 ? '\n' : ' ');
        }
        System.out.print(sb);
    }
}
