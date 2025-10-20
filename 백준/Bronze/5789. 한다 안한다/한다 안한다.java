import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            String input = br.readLine();

            int k = input.length() / 2;
            if(input.charAt(k) == input.charAt(k-1)) {
                sb.append("Do-it\n");
            } else {
                sb.append("Do-it-Not\n");
            }
        }

        System.out.print(sb);
    }
}
