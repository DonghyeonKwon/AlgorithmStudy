import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();

        int aCnt = a;
        int bCnt = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < a; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < b; i++) {
           int num = Integer.parseInt(st.nextToken());
           if(set.contains(num)) {
               aCnt--;
           } else {
               bCnt++;
           }
        }

        System.out.print(aCnt + bCnt);
    }
}
