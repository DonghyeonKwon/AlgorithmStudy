import java.io.*;
import java.util.*;

public class Main {

    static int[][] maxDP;
    static int[][] minDP;
    static char[] op;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int size = n/2 + 1;
        maxDP = new int[size][size];
        minDP = new int[size][size];
        op = new char[n/2];

        for(int i = 0; i < size; i++) {
            Arrays.fill(maxDP[i], Integer.MIN_VALUE);
            Arrays.fill(minDP[i], Integer.MAX_VALUE);
        }

        char[] input = br.readLine().toCharArray();
        int ni = 0;
        for(int i = 0; i < n; i += 2) {
            maxDP[ni][ni] = input[i] - '0';
            minDP[ni][ni] = input[i] - '0';
            ni++;
        }

        for(int count = 1; count < size; count++) {
            for(int index = 0; index < size - count; index++) {
                for(int i = 1, j = count; i <= count; i++, j--) {
                    char operator = input[(index + count - j) * 2 + 1];
                    List<Integer> temp = new ArrayList<>();

                    temp.add(calculate(minDP[index][index + count - j], minDP[index + i][index + count], operator));
                    temp.add(calculate(minDP[index][index + count - j], maxDP[index + i][index + count], operator));
                    temp.add(calculate(maxDP[index][index + count - j], minDP[index + i][index + count], operator));
                    temp.add(calculate(maxDP[index][index + count - j], maxDP[index + i][index + count], operator));

                    Collections.sort(temp);

                    minDP[index][index+count] = Math.min(minDP[index][index+count], temp.get(0));
                    maxDP[index][index+count] = Math.max(maxDP[index][index+count], temp.get(3));
                }
            }
        }

        System.out.print(maxDP[0][size - 1]);
    }

    static int calculate(int a, int b, char c) {
        if (c == '+') {
            return a + b;
        } else if(c == '-') {
            return a - b;
        }
        return a * b;
    }
}
