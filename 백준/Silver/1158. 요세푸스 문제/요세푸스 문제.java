import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 1; i <= n; i++) {
            q.add(i);
        }

        sb.append("<");
        while(!q.isEmpty()) {
            for(int i = 0; i < k-1; i++) {
                q.add(q.poll());
            }

            sb.append(q.poll());
            if(!q.isEmpty()) sb.append(", ");
        }
        sb.append(">");

        System.out.print(sb);
    }
}
