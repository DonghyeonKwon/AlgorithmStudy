import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = 1;
        int num = Integer.parseInt(br.readLine());

        while(num != 1) {
            int temp;
            if(num % 2 == 0) {
                temp = num / 2;
            } else {
                temp = 3 * num + 1;
            }

            num = temp;
            n++;
        }

        System.out.print(n);
    }
}
