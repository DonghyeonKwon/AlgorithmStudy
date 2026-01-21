import java.io.*;
import java.util.*;

public class Main {

    static int[] cup = {1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        for(int i = 0; i < input.length(); i++) {
            int temp;
            switch(input.charAt(i)) {
                case 'A':
                    temp = cup[1];
                    cup[1] = cup[0];
                    cup[0] = temp;
                    break;
                case 'B':
                    temp = cup[2];
                    cup[2] = cup[1];
                    cup[1] = temp;
                    break;
                case 'C':
                    temp = cup[2];
                    cup[2] = cup[0];
                    cup[0] = temp;
                    break;
            }
        }

        for(int i = 0; i < 3; i++) {
            if(cup[i] == 1) {
                System.out.print(i+1);
                break;
            }
        }
    }
}
