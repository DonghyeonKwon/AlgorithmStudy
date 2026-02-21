import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer>[] list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int color = Integer.parseInt(st.nextToken());

            list[color].add(num);
        }

        int sum = 0;

        for(int i = 1; i <= n; i++) {
            if(list[i].size() <= 1) continue;
            Collections.sort(list[i]);
            sum += list[i].get(1) - list[i].get(0);
            int len = list[i].size();
            for(int j = 1; j < len - 1; j++) {
                int p1 = list[i].get(j) - list[i].get(j-1);
                int p2 = list[i].get(j+1) - list[i].get(j);
                sum += Math.min(p1, p2);
            }

            sum += list[i].get(len - 1) - list[i].get(len - 2);
        }

        System.out.print(sum);
    }
}
