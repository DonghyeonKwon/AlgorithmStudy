import java.io.*;
import java.util.*;

public class Main {
    static char[][] monkeys;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        monkeys = new char[7][n];
        for(int i = 0; i < 7; i++) {
            Arrays.fill(monkeys[i], 'A');
        }

        go(0, 0, n -1);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 7; i++) {
            if(i > 0) monkeys[i][0] = 'B';
            for(int j = 0; j < n; j++) {
                sb.append(monkeys[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static void go(int day, int start, int end) {
        if(day == 7 || start >= end) return;

        int mid = (start + end) / 2;

        for(int i = start; i <= mid; i++) {
            monkeys[day][i] = 'A';
        }
        for(int i = mid + 1; i <= end; i++) {
            monkeys[day][i] = 'B';
        }

        go(day+1, start, mid);
        go(day + 1, mid + 1, end);
    }
}
