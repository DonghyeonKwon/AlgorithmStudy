import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String L = st.nextToken();
        String R = st.nextToken();

        int min = 0;

        if(L.length() != R.length()) {
            System.out.print(min);
        } else {
            int i = 0;
            while(i < L.length() && L.charAt(i) == R.charAt(i)) {
                if(L.charAt(i) == '8'){
                    min++;
                }
                i++;
            }
            System.out.print(min);
        }

    }
}
