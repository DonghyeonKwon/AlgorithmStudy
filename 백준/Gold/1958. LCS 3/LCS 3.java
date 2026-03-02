import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] arr = new char[3][];
        for(int i = 0; i < 3; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int[][][] dp = new int[arr[0].length + 1][arr[1].length + 1][arr[2].length + 1];
        for(int i = 1; i <= arr[0].length; i++) {
            for(int j = 1; j <= arr[1].length; j++) {
                for(int k = 1; k <= arr[2].length; k++) {
                    if(arr[0][i-1] == arr[1][j-1] && arr[1][j-1] == arr[2][k-1]) {
                        dp[i][j][k] = dp[i-1][j-1][k-1] + 1;
                    } else {
                        dp[i][j][k] = Math.max(dp[i-1][j][k], Math.max(dp[i][j-1][k], dp[i][j][k-1]));
                    }
                }
            }
        }

        System.out.print(dp[arr[0].length][arr[1].length][arr[2].length]);
    }
}
