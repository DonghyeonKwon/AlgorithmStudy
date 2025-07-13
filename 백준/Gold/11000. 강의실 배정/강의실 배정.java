import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (i, j) -> {
            if(i[0] == j[0]) return i[1] - j[1];
            return i[0] - j[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(arr[0][1]);

        for(int i = 1; i < n; i++){
            int a = pq.peek();
            if(arr[i][0] < a) pq.offer(arr[i][1]);
            else {
                pq.poll();
                pq.offer(arr[i][1]);
            }
        }

        System.out.print(pq.size());

    }
}
