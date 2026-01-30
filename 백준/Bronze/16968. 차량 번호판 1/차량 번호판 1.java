import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ans = 1;
        String input = br.readLine();

        int c = 26;
        int d = 10;
        char temp;

        if(input.charAt(0) == 'c') {
            ans *= c;
            temp = 'c';
        } else {
            ans *= d;
            temp = 'd';
        }

        for(int i = 1; i < input.length(); i++) {
            char e = input.charAt(i);

            if(e == 'c') {
                if(e == temp) {
                    ans *= 25;
                } else {
                    ans  *= 26;
                    temp = e;
                }
            } else {
                if(e == temp) {
                    ans *= 9;
                } else {
                    ans *= 10;
                    temp = e;
                }
            }
        }

        System.out.print(ans);
    }
}
