import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited = new boolean[26];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            StringBuilder sb = new StringBuilder();
            int check = check(str.split(" "));

            if(check >= 0) {
                String[] arr = str.split(" ");
                for(int j = 0; j < arr.length; j++) {
                    if(j == check) {
                        sb.append('[').append(arr[j].charAt(0)).append(']').append(arr[j].substring(1));
                    } else {
                        sb.append(arr[j]);
                    }

                    if(j < arr.length - 1) {
                        sb.append(' ');
                    }
                }

                list.add(sb.toString());
                continue;
            }

            boolean flag = true;
            for(int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if(c == ' ') sb.append(' ');
                else if('A' <= c && c <= 'Z') {
                    if(flag && !visited[c - 'A']) {
                        visited[c - 'A'] = true;
                        flag = false;
                        sb.append('[').append(c).append(']');
                    } else {
                        sb.append(c);
                    }
                } else {
                    if(flag && !visited[c - 'a']) {
                        visited[c - 'a'] = true;
                        flag = false;
                        sb.append('[').append(c).append(']');
                    } else {
                        sb.append(c);
                    }
                }
            }

            if(flag) {
                list.add(str);
            } else {
                list.add(sb.toString());
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(list.get(i)).append('\n');
        }

        System.out.print(sb);
    }

    static int check(String[] str) {
        for(int i = 0; i < str.length; i++) {
            char c = str[i].charAt(0);
            if('A' <= c && c <= 'Z') {
                if (!visited[str[i].charAt(0) - 'A']) {
                    visited[str[i].charAt(0) - 'A'] = true;
                    return i;
                }
            } else {
                if (!visited[str[i].charAt(0) - 'a']) {
                    visited[str[i].charAt(0) - 'a'] = true;
                    return i;
                }
            }
        }

        return -1;
    }
}
