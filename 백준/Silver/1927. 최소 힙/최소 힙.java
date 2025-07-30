import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());

        while(n-- > 0) {
            int input = Integer.parseInt(br.readLine());

            if(input == 0) {
                if(pq.isEmpty()) {
                    bw.write(0 + "\n");
                } else {
                    bw.write(pq.poll() + "\n");
                }
            } else {
                pq.add(input);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
