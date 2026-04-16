import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[5];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean flag = true;
        while(flag) {
            boolean f = false;
            for(int i = 0; i < 4; i++) {
                if(arr[i] > arr[i+1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;

                    for(int j = 0; j < 5; j++) {
                        sb.append(arr[j]).append(' ');
                    }
                    sb.append('\n');

                    f |= true;
                }
            }

            flag = f;
        }

        System.out.print(sb);
    }
}
