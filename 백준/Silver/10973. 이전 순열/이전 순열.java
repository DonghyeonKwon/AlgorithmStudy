import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (prevPermutation(arr)) {
            for(int i : arr) {
                sb.append(i).append(' ');
            }
        } else {
            sb.append(-1);
        }

        System.out.print(sb);
    }

    static boolean prevPermutation(int[] arr) {
        int n = arr.length;
        int i = n - 1;

        while(i > 0 && arr[i-1] < arr[i]) {
            i -= 1;
        }

        if(i <= 0) return false;

        int j = n - 1;

        while(arr[i-1] < arr[j]) {
            j -= 1;
        }

        int temp = arr[i-1];
        arr[i-1] = arr[j];
        arr[j] = temp;
        
        j = n - 1;

        while(i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i += 1;
            j -= 1;
        }

        return true;
    }
}
