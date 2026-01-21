import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[] arr = new int[4];
        arr[1] = 1;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int temp = arr[x];
            arr[x] = arr[y];
            arr[y] = temp;
        }

        for(int i = 1; i <= 3; i++) {
            if(arr[i] == 1) {
                System.out.print(i);
                break;
            }
        }
    }
}
