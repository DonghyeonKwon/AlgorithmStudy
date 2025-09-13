import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            String[] arr = br.readLine().split(",");

            for(int j = 0; j < arr.length; j++) {
                set.remove(arr[j]);
            }
            sb.append(set.size()).append('\n');
        }

        System.out.print(sb);
    }
}
