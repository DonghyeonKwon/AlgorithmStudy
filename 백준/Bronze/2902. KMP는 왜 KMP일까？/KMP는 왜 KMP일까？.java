import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split("-");
        StringBuilder sb = new StringBuilder();
        for(String str : input) {
            sb.append(str.charAt(0));
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}
