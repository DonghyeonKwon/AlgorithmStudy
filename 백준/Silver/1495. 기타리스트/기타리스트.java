import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] music = new int[m+1];
        for(int i = 0; i <= m; i++) {
            music[i] = -1;
        }

        music[s] = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            int volumn = Integer.parseInt(st.nextToken());

            List<Integer> list = new ArrayList<>();

            for(int j = 0; j <= m; j++) {
                if(music[j] == (i - 1)) {
                    int plus = j + volumn;
                    int minus = j - volumn;

                    if(0 <= plus && plus <= m) {
                        list.add(plus);
                    }
                    if(0 <= minus && minus <= m) {
                        list.add(minus);
                    }
                }
            }

            for(int j = 0; j < list.size(); j++) {
                music[list.get(j)] = i;
            }
        }

        int max = -1;
        for(int i = 0; i <= m; i++) {
            if(music[i] == n) {
                max = Math.max(max, i);
            }
        }

        System.out.print(max);
    }
}
