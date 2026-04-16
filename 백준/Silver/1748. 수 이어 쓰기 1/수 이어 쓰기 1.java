import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long res = 0L;
        String input = br.readLine();
        int len = input.length();
        int n = Integer.parseInt(input);

        if(input.length() == 1){
            bw.write(Integer.toString(n));
            bw.flush();

            bw.close();
            br.close();

            return;
        }

        int a = 1;
        for(int i = 1; i < len; i++){
            a *= 10;
        }

        res = (long) len * (n - a + 1);
        a = a * 9 / 10;
        len--;

        while(a > 0) {
            res += (long) len * a;

            a /= 10;
            len--;
        }

        bw.write(Long.toString(res));
        bw.flush();

        bw.close();
        br.close();
    }
}
