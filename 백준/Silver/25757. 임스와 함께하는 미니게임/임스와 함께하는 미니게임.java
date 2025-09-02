import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        char c = st.nextToken().charAt(0);
        Set<String> set = new HashSet<>();
        Queue<String> q = new ArrayDeque<>();

        int cnt = 0;
        int num = c == 'Y' ? 1 : c == 'F' ? 2 : 3;
        for(int i = 0; i < n; i++) {
            String str = br.readLine();

            if(set.contains(str)) continue;

            q.add(str);

            if(q.size() == num) {
                set.addAll(q);
                q.clear();
                cnt++;
            }
        }

        System.out.print(cnt);
    }
}
