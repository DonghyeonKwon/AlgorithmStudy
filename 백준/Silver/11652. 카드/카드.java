import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<Long, Integer> map = new HashMap<>();

        int max = 0;
        long res = 0;
        for(int i = 0; i < n; i++) {
            long input = Long.parseLong(br.readLine());
            map.put(input, map.getOrDefault(input, 0) + 1);
            if(max < map.get(input)) {
                max = map.get(input);
                res = input;
            } else if(max == map.get(input)) {
                res = Math.min(res, input);
            }
        }

        System.out.print(res);
    }
}
