import java.util.Scanner;

public class Main {
    private static char[] dc = {'A', 'C', 'G', 'T'};
    private static int n, m, _min = Integer.MAX_VALUE;
    private static String s;
    private static int[][] num = new int[4][50];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();
        scanner.nextLine(); // consume the remaining newline character
        
        for (int i = 0; i < n; i++) {
            s = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                if (s.charAt(j) == 'A') num[0][j]++;
                else if (s.charAt(j) == 'C') num[1][j]++;
                else if (s.charAt(j) == 'G') num[2][j]++;
                else if (s.charAt(j) == 'T') num[3][j]++;
            }
        }

        StringBuilder ret = new StringBuilder();
        int sum = 0;

        for (int i = 0; i < m; i++) {
            int cnt = 0, idx = 0;
            for (int j = 0; j < 4; j++) {
                if (cnt < num[j][i]) {
                    sum += cnt;
                    cnt = num[j][i];
                    idx = j;
                } else if (cnt >= num[j][i]) {
                    sum += num[j][i];
                }
            }
            ret.append(dc[idx]);
        }

        System.out.println(ret.toString());
        System.out.println(sum);
    }
}