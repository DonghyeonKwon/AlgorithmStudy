import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringTokenizer st = new StringTokenizer(br.readLine());

         int r1 = Integer.parseInt(st.nextToken());
         int s = Integer.parseInt(st.nextToken());

         int r2 = s * 2 - r1;

         System.out.println(r2);
    }
}
