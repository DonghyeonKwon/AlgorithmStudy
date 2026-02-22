import java.io.*;
import java.util.*;

public class Main {
    static int n, m, max = 0;
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());;

        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            map.put(input, map.getOrDefault(input, 0) + 1);
        }

        int k = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));

        for(String str : list) {
            int zeroCnt = 0;
            for(int i = 0; i < m; i++) {
                if(str.charAt(i) == '0') zeroCnt++;
            }

            if(zeroCnt > k) continue;

            if((k - zeroCnt) % 2 == 0) {
                max = map.get(str);
                break;
            }
        }

        System.out.print(max);
    }

}