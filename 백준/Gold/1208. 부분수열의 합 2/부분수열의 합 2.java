import java.io.*;
import java.util.*;

public class Main {
    static int n, s;
    static int[] arr;
    static List<Integer> left = new ArrayList<>();
    static List<Integer> right = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        calc(0, n/2, 0, left);
        calc(n/2, n, 0, right);

        Collections.sort(left);
        Collections.sort(right);

        long cnt = check();
        if(s == 0) cnt--;
        System.out.print(cnt);
    }

    static long check() {
        long cnt = 0;

        int li = 0;
        int ri = right.size() - 1;

        while(li < left.size() && ri >= 0) {
            int ln = left.get(li);
            int rn = right.get(ri);

            int temp = ln + rn;

            if(temp == s) {
                long leftCount = 0;
                while(li < left.size() && left.get(li) == ln) {
                    leftCount++;
                    li++;
                }

                long rightCount = 0;
                while(ri >= 0 && right.get(ri) == rn) {
                    rightCount++;
                    ri--;
                }
                cnt += (leftCount * rightCount);
            }

            if(temp > s) ri--;
            if(temp < s) li++;
        }

        return cnt;
    }

    static void calc(int start, int end, int sum, List<Integer> list) {
        if(start == end) {
            list.add(sum);
            return;
        }
        calc(start+1, end, sum, list);
        calc(start+1, end, sum + arr[start], list);
    }
}
