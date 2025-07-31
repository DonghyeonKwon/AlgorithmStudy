import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] maxDP = new int[n][3];
        int[][] minDP = new int[n][3];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                if(i == 0) {
                    int num = Integer.parseInt(st.nextToken());
                    maxDP[i][j] = num;
                    minDP[i][j] = num;
                    continue;
                }
                int num = Integer.parseInt(st.nextToken());
                if(j == 0) {
                    maxDP[i][j] = Math.max(
                            maxDP[i-1][j] + num,
                            maxDP[i-1][j+1] + num
                    );
                    minDP[i][j] = Math.min(
                            minDP[i-1][j] + num,
                            minDP[i-1][j+1] + num
                    );
                } else if(j == 1) {
                    maxDP[i][j] = Math.max(
                            maxDP[i-1][j] + num,
                            Math.max(
                                    maxDP[i-1][j+1] + num,
                                    maxDP[i-1][j-1] + num
                            )
                    );
                    minDP[i][j] = Math.min(
                            minDP[i-1][j] + num,
                            Math.min(
                                    minDP[i-1][j+1] + num,
                                    minDP[i-1][j-1] + num
                            )
                    );
                } else {
                    maxDP[i][j] = Math.max(
                            maxDP[i-1][j] + num,
                            maxDP[i-1][j-1] + num
                    );
                    minDP[i][j] = Math.min(
                            minDP[i-1][j] + num,
                            minDP[i-1][j-1] + num
                    );
                }

            }
        }

        int max = Math.max(maxDP[n-1][0], Math.max(maxDP[n-1][1], maxDP[n-1][2]));
        int min = Math.min(minDP[n-1][0], Math.min(minDP[n-1][1], minDP[n-1][2]));

        System.out.print(max + " " + min);

    }
}
