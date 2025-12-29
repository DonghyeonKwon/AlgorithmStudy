import java.io.*;
import java.util.*;

public class Main {
    static int n, w;
    static int[][] position;
    static int[][] dp;
    static int[][] path;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        w = Integer.parseInt(br.readLine());

        position = new int[w+1][2];
        dp = new int[w+1][w+1];
        path = new int[w+1][w+1];
        for(int[] row : dp) Arrays.fill(row, -1);

        for(int i = 1; i <= w; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            position[i][0] = Integer.parseInt(st.nextToken());
            position[i][1] = Integer.parseInt(st.nextToken());
        }

        int result = go(0, 0);
        System.out.println(result);
        search(0, 0);
    }

    static int go(int p1, int p2) {
        int next = Math.max(p1, p2) + 1;
        if(next > w) return 0;
        if(dp[p1][p2] != -1) return dp[p1][p2];

        int fromX1 = (p1 == 0) ? 1 : position[p1][0];
        int fromY1 = (p1 == 0) ? 1 : position[p1][1];
        int fromX2 = (p2 == 0) ? n : position[p2][0];
        int fromY2 = (p2 == 0) ? n : position[p2][1];

        int dist1 = Math.abs(fromX1 - position[next][0]) + Math.abs(fromY1 - position[next][1]);
        int dist2 = Math.abs(fromX2 - position[next][0]) + Math.abs(fromY2 - position[next][1]);

        int moveCar1 = dist1 + go(next, p2);
        int moveCar2 = dist2 + go(p1, next);

        if(moveCar1 < moveCar2) {
            path[p1][p2] = 1;
            dp[p1][p2] = moveCar1;
        } else {
            path[p1][p2] = 2;
            dp[p1][p2] = moveCar2;
        }

        return dp[p1][p2];
    }

    static void search(int p1, int p2) {
        int next = Math.max(p1, p2) + 1;
        if(next > w) return;

        int car = path[p1][p2];
        System.out.println(car);

        if(car == 1) search(next, p2);
        else search(p1, next);
    }
}
