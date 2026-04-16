import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 0;
        int max = -1;

        StringTokenizer st;
        for(int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());

            sum -= Integer.parseInt(st.nextToken());
            sum += Integer.parseInt(st.nextToken());

            max = Math.max(max, sum);
        }

        bw.write(Integer.toString(max));
        bw.flush();

        bw.close();
        br.close();
    }
}
