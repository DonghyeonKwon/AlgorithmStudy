import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int min  = Integer.MAX_VALUE;
        int alen = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a') alen++;
        }

        for(int i = 0; i < s.length(); i++) {
            int bCnt = 0;
            for(int j = i; j < alen + i; j++) {
                if(s.charAt(j % s.length()) == 'b') bCnt++;
            }
            
            min = Math.min(min, bCnt);
        }
        
        System.out.print(min);
    }
}
