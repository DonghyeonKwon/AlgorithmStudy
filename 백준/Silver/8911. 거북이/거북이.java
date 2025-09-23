import java.io.*;
import java.util.*;

public class Main {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(T-- > 0) {
            char[] arr = br.readLine().toCharArray();

            int d = 0;
            int y = 0, x = 0;
            int maxY = 0, minY = 0, maxX = 0, minX = 0;

            for(int i = 0; i < arr.length; i++) {
                char cmd = arr[i];

                switch(cmd) {
                    case 'F':
                        y += dy[d];
                        x += dx[d];
                        break;
                    case 'B':
                        y += dy[(d + 2) % 4];
                        x += dx[(d + 2) % 4];
                        break;
                    case 'L':
                        d += 1;
                        d %= 4;
                        break;
                    case 'R':
                        d -= 1;
                        if(d < 0) {
                            d = 3;
                        }
                        break;
                }

                maxY = Math.max(maxY, y);
                minY = Math.min(minY, y);
                maxX = Math.max(maxX, x);
                minX = Math.min(minX, x);
            }

            sb.append(Math.abs(maxY - minY) * Math.abs(maxX - minX)).append('\n');
        }

        System.out.print(sb);
    }
}
