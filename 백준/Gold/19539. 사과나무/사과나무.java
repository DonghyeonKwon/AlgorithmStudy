import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        int one = 0;
        int two = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            sum += num;
            one += num % 2;
            two += num / 2;
        }

        if(sum % 3 > 0 || one > two) {
            System.out.print("NO");
        } else {
            System.out.print("YES");
        }
    }
}
