import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();


        int prev = -1;
        boolean[] visited = new boolean[5000];

        while(true) {
            int num = input.charAt(0) - '0';
            int len = input.length();

            int nextNum = num * len;
            if(prev != -1 && nextNum == prev) {
                System.out.print("FA");
                break;
            }

            if(visited[nextNum]) {
                System.out.print("NFA");
                break;
            }

            prev = nextNum;
            input = String.valueOf(nextNum);
        }
    }
}
