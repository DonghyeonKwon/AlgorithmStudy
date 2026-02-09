import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String input = br.readLine();

            if(input.equals("end")) break;

            char[] arr = input.toCharArray();
            boolean ism = false;
            boolean flag = true;
            int mcnt = 0, jcnt = 0;

            for(int i = 0; flag && i < arr.length; i++) {
                char c = arr[i];
                if(check(c)) {
                    mcnt++;
                    jcnt = 0;
                    ism = true;
                } else {
                    jcnt++;
                    mcnt = 0;
                }

                if(mcnt == 3 || jcnt == 3) flag = false;
                if(i >= 1 && c == arr[i-1] && c != 'e' && c != 'o') flag = false;
            }

            flag &= ism;
            if(flag) {
                sb.append('<').append(input).append("> is acceptable.\n");
            } else {
                sb.append('<').append(input).append("> is not acceptable.\n");
            }
        }

        System.out.print(sb);
    }

    static boolean check(char c) {
        return c == 'a' || c == 'e' || c == 'o' || c == 'i' || c == 'u';
    }

}
