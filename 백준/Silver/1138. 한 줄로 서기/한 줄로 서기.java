import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] answer = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++) {
            int j = 1;

            while(true) {
                if(arr[i] == 0 && answer[j] == 0) {
                    answer[j] = i;
                    break;
                } else if(answer[j] == 0) {
                    arr[i]--;
                }

                j++;
            }
        }

        for(int i = 1; i <= n; i++) sb.append(answer[i]).append(' ');

        System.out.println(sb);
    }
}
