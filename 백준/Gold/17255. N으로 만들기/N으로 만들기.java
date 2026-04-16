import java.io.*;
import java.util.*;

public class Main {
    static char[] input;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine().toCharArray();
        for(int i = 0; i < input.length; i++) {
            dfs(i, i, "" + input[i], "" + input[i]);
        }

        System.out.print(set.size());
    }

    static void dfs(int left, int right, String str, String path) {
        if(left == 0 && right == input.length - 1) {
            set.add(path);
            return;
        }

        if(left - 1 >= 0) {
            dfs(left - 1, right, input[left - 1] +  str, path + " " + input[left] + str);
        }

        if(right + 1 < input.length) {
            dfs(left, right + 1, str + input[right + 1], path + " " + str + input[right]);
        }
    }
}
