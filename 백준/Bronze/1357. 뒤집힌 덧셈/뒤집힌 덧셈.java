import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s1 = st.nextToken();
        String s2 = st.nextToken();

        StringBuilder sb = new StringBuilder(s1);
        sb.reverse();
        s1 = sb.toString();
        sb = new StringBuilder(s2);
        sb.reverse();
        s2 = sb.toString();

        sb = new StringBuilder(String.valueOf(Integer.parseInt(s1) + Integer.parseInt(s2)));
        sb.reverse();

        System.out.print(Integer.parseInt(sb.toString()));
    }
}
