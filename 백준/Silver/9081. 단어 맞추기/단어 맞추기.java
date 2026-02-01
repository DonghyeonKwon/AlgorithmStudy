import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            char[] arr = br.readLine().toCharArray();

            nextPremutation(arr);
            sb.append(String.valueOf(arr)).append('\n');
        }

        System.out.print(sb);
    }

    static void nextPremutation(char[] arr) {
        int i = arr.length - 1;
        while(i > 0 && arr[i-1] >= arr[i]) {
            i -= 1;
        }

        if(i == 0) return;

        int j = arr.length - 1;
        while(arr[i-1] >= arr[j]) {
            j--;
        }

        char c = arr[i-1];
        arr[i-1] = arr[j];
        arr[j] = c;

        j = arr.length - 1;

        while(i <= j) {
            c = arr[i];
            arr[i] = arr[j];
            arr[j] = c;
            i++;
            j--;
        }
    }
}
