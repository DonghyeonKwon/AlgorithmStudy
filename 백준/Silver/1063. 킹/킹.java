import java.io.*;
import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] king = st.nextToken().toCharArray();

        char[] stone = st.nextToken().toCharArray();

        n = Integer.parseInt(st.nextToken());

        while(n-- > 0){
            String input = br.readLine();

            //앞에 돌이 있는지 없는지 확인
            //진행 할 수 있는지 없는지 확인
            switch(input){
                case "R": // [+1][]
                    if(king[0] + 1 == stone[0] && king[1] == stone[1]){
                        //stone 기준으로 진행할 수 있는지 확인
                        if(check(stone, 1, 0)){
                            king[0] = stone[0];

                            stone[0] += 1;
                        }
                    } else {
                        //king 기준으로 진행할 수 있는지 확인
                        if(check(king, 1, 0)){
                            king[0] += 1;
                        }
                    }
                    break;
                case "L": // [-1][]
                    if(king[0] - 1 == stone[0] && king[1] == stone[1]){
                        //stone 기준으로 진행할 수 있는지 확인
                        if(check(stone, -1, 0)){
                            king[0] = stone[0];
                            stone[0] -= 1;
                        }
                    } else {
                        //king 기준으로 진행할 수 있는지 확인
                        if(check(king, -1, 0)){
                            king[0] -= 1;
                        }
                    }
                     break;
                case "B": // [][-1]
                    if(king[0] == stone[0] && king[1] - 1 == stone[1]){
                        //stone 기준으로 진행할 수 있는지 확인
                        if(check(stone, 0, -1)){
                            king[1] = stone[1];
                            stone[1] -= 1;
                        }
                    } else {
                        //king 기준으로 진행할 수 있는지 확인
                        if(check(king, 0, -1)){
                            king[1] -= 1;
                        }
                    }
                    break;
                case "T": // [][+1]
                    if(king[0] == stone[0] && king[1] + 1 == stone[1]){
                        //stone 기준으로 진행할 수 있는지 확인
                        if(check(stone, 0, 1)){
                            king[1] = stone[1];
                            stone[1] += 1;
                        }
                    } else {
                        //king 기준으로 진행할 수 있는지 확인
                        if(check(king, 0, 1)){
                            king[1] += 1;
                        }
                    }
                    break;
                case "RT": // [+1][+1]
                    if(king[0] + 1 == stone[0] && king[1] + 1 == stone[1]){
                        //stone 기준으로 진행할 수 있는지 확인
                        if(check(stone, 1, 1)){
                            king[0] = stone[0];
                            king[1] = stone[1];

                            stone[0] += 1;
                            stone[1] += 1;
                        }
                    } else {
                        //king 기준으로 진행할 수 있는지 확인
                        if(check(king, 1, 1)){
                            king[0] += 1;
                            king[1] += 1;
                        }
                    }
                    break;
                case "LT": // [-1][+1]
                    if(king[0] - 1 == stone[0] && king[1] + 1 == stone[1]){
                        //stone 기준으로 진행할 수 있는지 확인
                        if(check(stone, -1, +1)){
                            king[0] = stone[0];
                            king[1] = stone[1];

                            stone[0] -= 1;
                            stone[1] += 1;
                        }
                    } else {
                        //king 기준으로 진행할 수 있는지 확인
                        if(check(king, -1, 1)){
                            king[0] -= 1;
                            king[1] += 1;
                        }
                    }
                    break;
                case "RB": // [+1][-1]
                    if(king[0] + 1 == stone[0] && king[1] - 1 == stone[1]){
                        //stone 기준으로 진행할 수 있는지 확인
                        if(check(stone, 1, -1)){
                            king[0] = stone[0];
                            king[1] = stone[1];

                            stone[0] += 1;
                            stone[1] -= 1;
                        }
                    } else {
                        //king 기준으로 진행할 수 있는지 확인
                        if(check(king, 1, -1)){
                            king[0] += 1;
                            king[1] -= 1;
                        }
                    }
                    break;
                case "LB":  // [-1][-1]
                    if(king[0] - 1 == stone[0] && king[1] - 1 == stone[1]){
                        //stone 기준으로 진행할 수 있는지 확인
                        if(check(stone, -1, -1)){
                            king[0] = stone[0];
                            king[1] = stone[1];

                            stone[0] -= 1;
                            stone[1] -= 1;
                        }
                    } else {
                        //king 기준으로 진행할 수 있는지 확인
                        if(check(king, -1, -1)){
                            king[0] -= 1;
                            king[1] -= 1;
                        }
                    }
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(king).append('\n').append(stone).append('\n');

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }

    static boolean check(char[] horse, int dx, int dy) {
        char ny = (char) (horse[1] + dy);
        char nx = (char) (horse[0] + dx);

        if('1' <= ny && ny <= '8' && 'A' <= nx && nx <= 'H') return true;
        return false;
    }
}
