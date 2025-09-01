import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int maxHeight = Math.max(a, b);
        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < a; i++) {
            dq.add(i);
        }
        dq.add(maxHeight);

        for(int i = b - 1; i > 0; i--) {
            dq.add(i);
        }

        if(dq.size() > n) {
            System.out.print(-1);
            return;
        }

        int qSize = dq.size();
        int first = dq.poll();

        for(int i = 1; i <= n-qSize; i++) {
            dq.addFirst(1);
        }
        dq.addFirst(first);

        while(!dq.isEmpty()) {
            sb.append(dq.poll()).append(' ');
        }

        System.out.print(sb);
    }
}
