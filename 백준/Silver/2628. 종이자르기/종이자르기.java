import java.io.*;
import java.util.*;

public class Main {
    static int r, c;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        int p = Integer.parseInt(br.readLine());
        List<Integer> garo = new ArrayList<>();
        List<Integer> sero = new ArrayList<>();
        while(p-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if(n == 0) {
                garo.add(k);
            } else {
                sero.add(k);
            }
        }

        Collections.sort(garo);
        Collections.sort(sero);

        int[] sArr = new int[garo.size() + 1];
        int[] gArr = new int[sero.size() + 1];

        int prev = 0;
        int idx = 0;
        for(int i : sero) {
            gArr[idx] = i - prev;
            prev = i;
            idx++;
        }
        gArr[idx] = c - prev;

        prev = 0;
        idx = 0;
        for(int i : garo) {
            sArr[idx] = i - prev;
            prev = i;
            idx++;
        }
        sArr[idx] = r - prev;

        int max = 0;
        for(int i = 0; i < sArr.length; i++) {
            for(int j = 0; j < gArr.length; j++) {
                max = Math.max(max, gArr[j] * sArr[i]);
            }
        }

        System.out.print(max);
    }
}
