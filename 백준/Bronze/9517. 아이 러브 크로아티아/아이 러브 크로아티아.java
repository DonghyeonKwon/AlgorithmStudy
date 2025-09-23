import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int time = 0;
        int idx = 0;

        Question[] arr = new Question[N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Question(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
        }

        while(time < 210) {
            time += arr[idx].t;

            if(time >= 210) {
                break;
            }

            if(arr[idx].c == 'T') {
                num++;
                if(num > 8) {
                    num = 1;
                }
            }

            idx++;
        }

        System.out.print(num);
    }

    static class Question {
        int t;
        char c;

        Question(int t, char c) {
            this.t = t;
            this.c = c;
        }
    }
}
