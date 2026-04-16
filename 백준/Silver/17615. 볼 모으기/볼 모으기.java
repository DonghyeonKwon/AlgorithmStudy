import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cntR = 0;
        int cntB = 0;
        int answer = 1000000;

        int n = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();

        for(int i = 0; i < n; i++) {
            if(arr[i] == 'R') cntR++;
            else cntB++;
        }

        int firstBallCnt = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] == 'R'){
                firstBallCnt++;
            } else break;
        }
        answer = Math.min(answer, cntR - firstBallCnt);

        firstBallCnt = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] == 'B'){
                firstBallCnt++;
            } else break;
        }
        answer = Math.min(answer, cntB - firstBallCnt);

        firstBallCnt = 0;
        for(int i = n-1; i >= 0; i--) {
            if(arr[i] == 'R'){
                firstBallCnt++;
            } else break;
        }
        answer = Math.min(answer, cntR - firstBallCnt);

        firstBallCnt = 0;
        for(int i = n-1; i >= 0; i--) {
            if(arr[i] == 'B'){
                firstBallCnt++;
            } else break;
        }
        answer = Math.min(answer, cntB - firstBallCnt);

        System.out.print(answer);
    }
}
