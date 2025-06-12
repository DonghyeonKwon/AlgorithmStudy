import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10];

        while(n > 0) {
            int m = n % 10;
            arr[m]++;
            n /= 10;
        }

        int a = (arr[6] + arr[9]) / 2;
        if((arr[6] + arr[9]) % 2 != 0) a += 1;
        arr[6] = arr[9] = a;

        int max = -1;
        for(int i = 0; i < 10; i++){
            max = max < arr[i] ? arr[i] : max;
        }

        bw.write(Integer.toString(max));
        bw.flush();

        bw.close();
        br.close();
    }
}
