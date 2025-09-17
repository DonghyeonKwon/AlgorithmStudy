import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 6; i >= 0; i--) {
            if((n & (1 << i)) > 0) {
                System.out.print(1 << i);
                break;
            }
        }
    }
}
