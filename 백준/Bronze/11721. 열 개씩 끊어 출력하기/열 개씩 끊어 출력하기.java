import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        for(int i = 0; i < input.length(); i += 10) {
            if(i + 10 > input.length()) {
                bw.write(input.substring(i));
            }
            else bw.write(input.substring(i, i + 10));
            bw.write("\n");
        }

        bw.flush();

        bw.close();
        br.close();
    }
}
