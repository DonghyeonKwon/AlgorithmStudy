import java.util.*;
import java.io.*;

public class Main {
    static int max = -1, idx = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] map = new int[5];

        for(int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                map[j] = Integer.parseInt(st.nextToken());
            }

            for(int k = 0; k < 3; k++) {
                for(int l = k+1; l < 4; l++) {
                    for(int m = l+1; m < 5; m++) {
                        int res = map[k] + map[l] + map[m];
                        res %= 10;

                        if(max < res) {
                            max = res;
                            idx = i;
                        } else if(max == res) {
                            idx = i;
                        }
                    }
                }
            }
        }

        System.out.print(idx);
    }
}
