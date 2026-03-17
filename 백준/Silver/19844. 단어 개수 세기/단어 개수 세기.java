import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");
        List<String> list = new ArrayList<>();

        for(String str : arr) {
            String[] brr = str.split("-");

            list.addAll(Arrays.asList(brr));
        }

        int ans = 0;
        for(String str : list) {
            String[] brr = str.split("'");
            if(brr.length == 1) {
                ans += 1;
                continue;
            }
            ans += check(brr[0]) && check2(brr[1].charAt(0)) ? 2 : 1;
        }

        System.out.print(ans);
    }

    static boolean check(String str) {
        boolean flag = false;

        switch(str) {
            case "c": case "s": case "l": case "d": case "qu":
            case "j": case "n": case "m": case "t":
                flag = true;
            break;
        }

        return flag;
    }

    static boolean check2(char a) {
        return a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u' || a == 'h';
    }
}
