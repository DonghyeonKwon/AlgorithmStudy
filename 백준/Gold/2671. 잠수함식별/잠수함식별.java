import java.io.*;
import java.util.*;

public class Main {
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        boolean flag = input.matches("(100+1+|01)+");

        System.out.print(flag ? "SUBMARINE" : "NOISE");
    }

}
