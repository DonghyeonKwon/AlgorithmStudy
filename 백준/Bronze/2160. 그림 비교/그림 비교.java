import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][][] map = new char[n][5][7];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 5; j++) {
                map[i][j] = br.readLine().toCharArray();
            }
        }

        int min = 100;
        int a=0, b=0;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int cnt = 0;
                for(int y = 0; y < 5; y++) {
                    for(int x = 0; x < 7; x++) {
                        if(map[i][y][x] != map[j][y][x]) cnt++;
                    }
                }

                if(min > cnt) {
                    min = cnt;
                    a = i+1;
                    b = j+1;
                }
            }
        }

        System.out.print(a + " " + b);
    }
}
