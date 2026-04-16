import java.util.Scanner;

public class Main {
    static int n, m, choose[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        choose = new int[m];

        permutation(0);

        System.out.println(sb);
    }

    private static void permutation(int idx) {
        if(idx == m) {
            for(int i = 0; i < m; i++) {
                sb.append(choose[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        for(int i = 1; i <= n; i++){
            choose[idx] = i;
            permutation(idx + 1);
        }
    }
}
