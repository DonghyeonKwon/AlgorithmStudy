import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[][] arr = new int[T][20];
        int[] answer = new int[T];
        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            for(int j = 0; j < 20; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(j == 0) {
                    arr[i][j] = num;
                    continue;
                }
                int k = 0;
                for(; k < j; k++) {
                    if(arr[i][k] > num) break;
                }

                for(int p = j; p > k; p--) {
                    arr[i][p] = arr[i][p-1];
                    answer[i]++;
                }

                arr[i][k] = num;
            }
        }



        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++) {
            sb.append(i+1).append(" ").append(answer[i]).append('\n');
        }
        System.out.print(sb);
    }
}
