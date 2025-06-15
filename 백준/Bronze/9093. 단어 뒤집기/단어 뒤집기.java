import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            while(st.hasMoreTokens()){
                char[] arr = st.nextToken().toCharArray();

                for(int j = 0; j < arr.length / 2; j++) {
                    char temp = arr[j];
                    arr[j] = arr[arr.length - 1 - j];
                    arr[arr.length - 1 - j] = temp;
                }

                sb.append(arr).append(' ');
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}
