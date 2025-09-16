import java.io.*;
import java.util.*;

public class Main {

    static char[][] cube;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while(t-- > 0) {
            initCube();

            int n = sc.nextInt();
            for(int i = 0; i < n; i++) {
                char[] input = sc.next().toCharArray();
                rotate(input);
            }

            for(int i = 0; i < 9; i++) {
                sb.append(cube[0][i]);
                if((i+1) % 3 == 0) sb.append('\n');
            }

        }

        System.out.print(sb);
    }

    static void rotate(char[] input) {
        int index = -1;
        char[][] temp = copy();

        if(input[0] == 'U') {
            index = 0;
        } else if(input[0] == 'D') {
            index = 1;
        } else if(input[0] == 'F') {
            index = 2;
        } else if(input[0] == 'B') {
            index = 3;
        } else if(input[0] == 'L') {
            index = 4;
        } else if(input[0] == 'R') {
            index = 5;
        }

        if(input[1] == '+') {
            cube[index][0] = temp[index][6]; cube[index][1] = temp[index][3]; cube[index][2] = temp[index][0];
            cube[index][3] = temp[index][7]; cube[index][4] = temp[index][4]; cube[index][5] = temp[index][1];
            cube[index][6] = temp[index][8]; cube[index][7] = temp[index][5]; cube[index][8] = temp[index][2];

            if(input[0] == 'U') {
                cube[2][0] = temp[5][0]; cube[2][1] = temp[5][1]; cube[2][2] = temp[5][2];
                cube[4][0] = temp[2][0]; cube[4][1] = temp[2][1]; cube[4][2] = temp[2][2];
                cube[3][0] = temp[4][0]; cube[3][1] = temp[4][1]; cube[3][2] = temp[4][2];
                cube[5][0] = temp[3][0]; cube[5][1] = temp[3][1]; cube[5][2] = temp[3][2];
            }else if(input[0]  == 'D') {
                cube[5][6] = temp[2][6]; cube[5][7] = temp[2][7]; cube[5][8] = temp[2][8];
                cube[3][6] = temp[5][6]; cube[3][7] = temp[5][7]; cube[3][8] = temp[5][8];
                cube[4][6] = temp[3][6]; cube[4][7] = temp[3][7]; cube[4][8] = temp[3][8];
                cube[2][6] = temp[4][6]; cube[2][7] = temp[4][7]; cube[2][8] = temp[4][8];
            }else if(input[0] == 'F') {
                cube[5][0] = temp[0][6]; cube[5][3] = temp[0][7]; cube[5][6] = temp[0][8];
                cube[1][2] = temp[5][0]; cube[1][1] = temp[5][3]; cube[1][0] = temp[5][6];
                cube[4][2] = temp[1][0]; cube[4][5] = temp[1][1]; cube[4][8] = temp[1][2];
                cube[0][8] = temp[4][2]; cube[0][7] = temp[4][5]; cube[0][6] = temp[4][8];
            }else if(input[0] == 'B') {
                cube[4][6] = temp[0][0]; cube[4][3] = temp[0][1]; cube[4][0] = temp[0][2];
                cube[1][6] = temp[4][0]; cube[1][7] = temp[4][3]; cube[1][8] = temp[4][6];
                cube[5][8] = temp[1][6]; cube[5][5] = temp[1][7]; cube[5][2] = temp[1][8];
                cube[0][0] = temp[5][2]; cube[0][1] = temp[5][5]; cube[0][2] = temp[5][8];
            }else if(input[0] == 'L') {
                cube[2][0] = temp[0][0]; cube[2][3] = temp[0][3]; cube[2][6] = temp[0][6];
                cube[1][0] = temp[2][0]; cube[1][3] = temp[2][3]; cube[1][6] = temp[2][6];
                cube[3][8] = temp[1][0]; cube[3][5] = temp[1][3]; cube[3][2] = temp[1][6];
                cube[0][6] = temp[3][2]; cube[0][3] = temp[3][5]; cube[0][0] = temp[3][8];
            }else if(input[0] == 'R') {
                cube[3][6] = temp[0][2]; cube[3][3] = temp[0][5]; cube[3][0] = temp[0][8];
                cube[1][8] = temp[3][0]; cube[1][5] = temp[3][3]; cube[1][2] = temp[3][6];
                cube[2][2] = temp[1][2]; cube[2][5] = temp[1][5]; cube[2][8] = temp[1][8];
                cube[0][2] = temp[2][2]; cube[0][5] = temp[2][5]; cube[0][8] = temp[2][8];
            }

        } else {
            cube[index][0] = temp[index][2]; cube[index][1] = temp[index][5]; cube[index][2] = temp[index][8];
            cube[index][3] = temp[index][1]; cube[index][4] = temp[index][4]; cube[index][5] = temp[index][7];
            cube[index][6] = temp[index][0]; cube[index][7] = temp[index][3]; cube[index][8] = temp[index][6];

            if(input[0] == 'U') {
                cube[5][0] = temp[2][0]; cube[5][1] = temp[2][1]; cube[5][2] = temp[2][2];
                cube[2][0] = temp[4][0]; cube[2][1] = temp[4][1]; cube[2][2] = temp[4][2];
                cube[4][0] = temp[3][0]; cube[4][1] = temp[3][1]; cube[4][2] = temp[3][2];
                cube[3][0] = temp[5][0]; cube[3][1] = temp[5][1]; cube[3][2] = temp[5][2];
            }else if(input[0] == 'D') {
                cube[2][6] = temp[5][6]; cube[2][7] = temp[5][7]; cube[2][8] = temp[5][8];
                cube[5][6] = temp[3][6]; cube[5][7] = temp[3][7]; cube[5][8] = temp[3][8];
                cube[3][6] = temp[4][6]; cube[3][7] = temp[4][7]; cube[3][8] = temp[4][8];
                cube[4][6] = temp[2][6]; cube[4][7] = temp[2][7]; cube[4][8] = temp[2][8];
            }else if(input[0] == 'F') {
                cube[4][8] = temp[0][6]; cube[4][5] = temp[0][7]; cube[4][2] = temp[0][8];
                cube[1][0] = temp[4][2]; cube[1][1] = temp[4][5]; cube[1][2] = temp[4][8];
                cube[5][6] = temp[1][0]; cube[5][3] = temp[1][1]; cube[5][0] = temp[1][2];
                cube[0][6] = temp[5][0]; cube[0][7] = temp[5][3]; cube[0][8] = temp[5][6];
            }else if(input[0] == 'B') {
                cube[5][2] = temp[0][0]; cube[5][5] = temp[0][1]; cube[5][8] = temp[0][2];
                cube[1][8] = temp[5][2]; cube[1][7] = temp[5][5]; cube[1][6] = temp[5][8];
                cube[4][0] = temp[1][6]; cube[4][3] = temp[1][7]; cube[4][6] = temp[1][8];
                cube[0][2] = temp[4][0]; cube[0][1] = temp[4][3]; cube[0][0] = temp[4][6];
            }else if(input[0] == 'L') {
                cube[0][0] = temp[2][0]; cube[0][3] = temp[2][3]; cube[0][6] = temp[2][6];
                cube[3][8] = temp[0][0]; cube[3][5] = temp[0][3]; cube[3][2] = temp[0][6];
                cube[1][6] = temp[3][2]; cube[1][3] = temp[3][5]; cube[1][0] = temp[3][8];
                cube[2][0] = temp[1][0]; cube[2][3] = temp[1][3]; cube[2][6] = temp[1][6];
            }else if(input[0] == 'R') {
                cube[2][2] = temp[0][2]; cube[2][5] = temp[0][5]; cube[2][8] = temp[0][8];
                cube[1][2] = temp[2][2]; cube[1][5] = temp[2][5]; cube[1][8] = temp[2][8];
                cube[3][6] = temp[1][2]; cube[3][3] = temp[1][5]; cube[3][0] = temp[1][8];
                cube[0][8] = temp[3][0]; cube[0][5] = temp[3][3]; cube[0][2] = temp[3][6];
            }
        }

    }

    static char[][] copy() {
        char[][] temp = new char[6][9];
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 9; j++) {
                temp[i][j] = cube[i][j];
            }
        }

        return temp;
    }

    static void initCube() {
        cube = new char[6][9];
        char[] arr = {'w', 'y', 'r', 'o', 'g', 'b'};

        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 9; j++) {
                cube[i][j] = arr[i];
            }
        }
    }
}
