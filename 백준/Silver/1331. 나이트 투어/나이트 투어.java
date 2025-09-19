import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[36][2];
        boolean[][] visited = new boolean[6][6];

        int[] dy = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dx = {-1, 1, -2, 2, -2, 2, -1, 1};

        for(int i = 0; i < 36; i++) {
            String input = br.readLine();
            int y = input.charAt(0) - 'A';
            int x = input.charAt(1) - '1';

            arr[i][0] = y;
            arr[i][1] = x;
        }

        boolean flag = true;
        visited[arr[0][0]][arr[0][1]] = true;
        for(int i = 0; i < 35 && flag; i++) {
            if(visited[arr[i+1][0]][arr[i+1][1]]) {
                flag = false;
                break;
            }

            visited[arr[i+1][0]][arr[i+1][1]] = true;
            int ddy = arr[i][0] - arr[i+1][0];
            int ddx = arr[i][1] - arr[i+1][1];

            boolean f = false;
            for(int d = 0; d < 8; d++) {
                if(dy[d] == ddy && dx[d] == ddx) {
                    f = true;
                    break;
                }
            }

            flag &= f;
        }

        int ddy = arr[35][0] - arr[0][0];
        int ddx = arr[35][1] - arr[0][1];
        boolean f = false;
        for(int d = 0; d < 8; d++) {
            if(dy[d] == ddy && dx[d] == ddx) {
                f = true;
                break;
            }
        }

        flag &= f;

        if(flag) {
            System.out.print("Valid");
        } else {
            System.out.print("Invalid");
        }

    }
}
