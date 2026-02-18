import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int score = 0;
        int[][] green = new int[6][4];
        int[][] blue = new int[4][6];

        int n = Integer.parseInt(br.readLine());
        int t, x, y;

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            if(t == 1) {
                //green
                int j = 0;
                for(; j < 6; j++) {
                    if(green[j][y] != 0) break;
                }
                j -= 1;
                green[j][y] = 1;

                int k = 0;
                for(; k < 6; k++) {
                    if(blue[x][k] != 0) break;
                }
                k -= 1;
                blue[x][k] = 1;

            } else if(t == 2) {
                int j = 0;
                for(; j < 6; j++) {
                    if(green[j][y] != 0 || green[j][y+1] != 0) break;
                }
                j -= 1;
                green[j][y] = green[j][y+1]= 1;

                int k = 1;
                for(; k < 6; k++) {
                    if(blue[x][k] != 0) break;
                }
                k -= 1;
                blue[x][k] = blue[x][k-1] = 1;
            } else if(t == 3) {
                int j = 1;
                for(; j < 6; j++) {
                    if(green[j][y] != 0) break;
                }
                j -= 1;
                green[j][y] = green[j-1][y]= 1;

                int k = 0;
                for(; k < 6; k++) {
                    if(blue[x][k] != 0 || blue[x+1][k] != 0) break;
                }
                k -= 1;
                blue[x][k] = blue[x+1][k] = 1;
            }

            //점수 확인
            boolean blueFlag = false;
            boolean greenFlag = false;

            int k = 2;
            for(; k < 6; k++) {
                int blueCnt = 0;
                int greenCnt = 0;
                for(int j = 0; j < 4; j++) {
                    if(blue[j][k] == 1) blueCnt++;
                    if(green[k][j] == 1) greenCnt++;
                }

                if(blueCnt == 4) {
                    blueFlag = true;
                    score++;
                    for(int j = 0; j < 4; j++) {
                        blue[j][k] = 0;
                    }
                }

                if(greenCnt == 4) {
                    greenFlag = true;
                    score++;
                    for(int j = 0; j < 4; j++) {
                        green[k][j] = 0;
                    }
                }
            }

            //
            if(blueFlag) {
                Queue<int[]> q = new ArrayDeque<>();

                for(int b = 5; b >= 0; b--) {
                    int[] arr = new int[4];
                    int zeroCnt = 0;
                    for(int a = 0; a < 4; a++) {
                        if(blue[a][b] == 0) zeroCnt++;
                        arr[a] = blue[a][b];
                    }

                    if(zeroCnt < 4) {
                        q.add(arr);
                    }
                }

                int b = 5;
                while(!q.isEmpty()) {
                    int[] arr = q.poll();

                    for(int a = 0; a < 4; a++) {
                        blue[a][b] = arr[a];
                    }
                    b--;
                }

                for(; b >= 0; b--){
                    for(int a = 0; a < 4; a++) {
                        blue[a][b] = 0;
                    }
                }
            }

            if(greenFlag) {
                Queue<int[]> q = new ArrayDeque<>();

                for(int b = 5; b >= 0; b--) {
                    int[] arr = new int[4];
                    int zeroCnt = 0;
                    for(int a = 0; a < 4; a++) {
                        if(green[b][a] == 0) zeroCnt++;
                        arr[a] = green[b][a];
                    }

                    if(zeroCnt < 4) {
                        q.add(arr);
                    }
                }

                int b = 5;
                while(!q.isEmpty()) {
                    int[] arr = q.poll();

                    for(int a = 0; a < 4; a++) {
                        green[b][a] = arr[a];
                    }
                    b--;
                }

                for(; b >= 0; b--) {
                    for(int a = 0; a < 4; a++) {
                        green[b][a] = 0;
                    }
                }
            }

            int errorBlue = 0, errorGreen = 0;
            for(int b = 1; b >= 0; b--) {
                for(int a = 0; a < 4; a++) {
                    if(blue[a][b] == 1) {
                        errorBlue |= (1 << b);
                    }
                    if(green[b][a] == 1) {
                        errorGreen |= (1 << b);
                    }
                }
            }

            if(errorBlue == 2) {
                int[][] tmp = new int[4][4];
                for(int a = 0; a < 4; a++) {
                    for(int b = 1; b <= 4; b++) {
                        tmp[a][b-1] = blue[a][b];
                    }
                }

                for(int a = 0; a < 4; a++) {
                    for(int b = 2; b <= 5; b++) {
                        blue[a][b] = tmp[a][b-2];
                    }
                }

                for(int b = 0; b < 2; b++) {
                    for(int a = 0; a < 4; a++) {
                        blue[a][b] = 0;
                    }
                }
            } else if(errorBlue == 3) {
                int[][] tmp = new int[4][4];
                for(int a = 0; a < 4; a++) {
                    for(int b = 0; b < 4; b++) {
                        tmp[a][b] = blue[a][b];
                    }
                }

                for(int a = 0; a < 4; a++) {
                    for(int b = 2; b <= 5; b++) {
                        blue[a][b] = tmp[a][b-2];
                    }
                }

                for(int b = 0; b < 2; b++) {
                    for(int a = 0; a < 4; a++) {
                        blue[a][b] = 0;
                    }
                }
            }

            if(errorGreen == 2) {
                int[][] tmp = new int[4][4];

                for(int a = 1; a < 5; a++) {
                    for(int b = 0; b < 4; b++) {
                        tmp[a-1][b] = green[a][b];
                    }
                }

                for(int a = 2; a < 6; a++) {
                    for(int b = 0; b < 4; b++) {
                        green[a][b] = tmp[a-2][b];
                    }
                }

                for(int a = 0; a < 2; a++) {
                    for(int b = 0; b < 4; b++) {
                        green[a][b] = 0;
                    }
                }
            } else if(errorGreen == 3) {
                int[][] tmp = new int[4][4];

                for(int a = 0; a < 4; a++){
                    for(int b = 0; b < 4; b++) {
                        tmp[a][b] = green[a][b];
                    }
                }

                for(int a = 2; a < 6; a++) {
                    for(int b = 0; b < 4; b++) {
                        green[a][b] = tmp[a-2][b];
                    }
                }

                for(int a = 0; a < 2; a++) {
                    for(int b = 0; b < 4; b++) {
                        green[a][b] = 0;
                    }
                }
            }
        }

        int sum = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 2; j < 6; j++){
                if(blue[i][j] > 0) sum++;
                if(green[j][i] > 0) sum++;
            }
        }

        System.out.println(score);
        System.out.println(sum);
    }
}
