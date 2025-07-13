import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            pq.offer(input);
        }

        int sum = 0;
        while(pq.size() != 1) {
            int i = pq.poll();
            int j = pq.poll();

            sum += i+j;

            pq.offer(i+j);
        }

        System.out.print(sum);
    }
}
