import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().split(" ");

            StringBuilder result = new StringBuilder();
            result.append(arr[0]);
            for(int i = 1; i < n; i++) {
                if(result.charAt(0) >= arr[i].charAt(0)) {
                    result.insert(0, arr[i]);
                } else {
                    result.append(arr[i]);
                }
            }

            sb.append(result).append('\n');
        }

        System.out.print(sb);
    }
}
