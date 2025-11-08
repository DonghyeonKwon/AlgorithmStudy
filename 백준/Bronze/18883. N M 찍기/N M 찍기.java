import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        for(int i = 1; i <= n*m; i++) {
            sb.append(i);
            if(i % m == 0) {
                sb.append('\n');
            } else {
                sb.append(" ");
            }
        }

        System.out.print(sb);
    }
}
