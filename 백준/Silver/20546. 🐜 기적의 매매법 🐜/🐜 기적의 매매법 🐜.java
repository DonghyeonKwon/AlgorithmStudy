import java.io.*;
import java.util.*;

public class Main {
    static int[] arr = new int[14];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int money = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 14; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int junhyeon = BNP(money);
        int sungmin = TIMING(money);

        if(junhyeon > sungmin) {
            System.out.print("BNP");
        } else if(junhyeon < sungmin) {
            System.out.print("TIMING");
        } else {
            System.out.print("SAMESAME");
        }
    }

    static int BNP(int money) {
        int cnt = 0;

        for(int i = 0; i < 14; i++) {
            if(money >= arr[i]) {
                cnt += money / arr[i];
                money %= arr[i];
            }
        }

        return money + cnt * arr[13];
    }

    static int TIMING(int money) {
        int cnt = 0;
        int increasing = 0;
        int decreasing = 0;

        for(int i = 1; i < 14; i++) {
            if(arr[i-1] < arr[i]) {
                increasing += 1;
                decreasing = 0;
            } else if(arr[i-1] > arr[i]) {
                decreasing += 1;
                increasing = 0;
            }

            if(increasing == 3) {
                money += cnt * arr[i];
                increasing = 0;
            } else if(decreasing == 3) {
                cnt += money / arr[i];
                money %= arr[i];
                decreasing = 0;
            }
        }

        return money + cnt * arr[13];
    }
}
