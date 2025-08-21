import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        int max = 0;
        String a = "";
        String b = "";
        for(int i = 0; i < n-1; i++) {
            if(arr[i].length() < max) continue;
            for(int j = i + 1; j < n; j++) {
                if(arr[j].length() < max) continue;

                int len = comp(arr[i], arr[j]);

                if(max < len) {
                    max = len;
                    a = arr[i];
                    b = arr[j];
                }
            }
        }

        System.out.println(a);
        System.out.println(b);

    }

    static int comp(String a, String b) {
        int idx = 0;
        int min = Math.min(a.length(), b.length());
        while(idx < min && a.charAt(idx) == b.charAt(idx)) {
            idx++;
        }

        return idx;
    }
}
