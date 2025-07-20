import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        List<Integer> arr = new ArrayList<>();
        List<Integer> brr = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());
            if(a > 0) arr.add(a);
            else brr.add(a);
        }

        Collections.sort(arr);
        Collections.sort(brr);

        while(arr.size() > 1 || brr.size() > 1) {
            if(arr.size() > 1) {
                if(arr.get(arr.size() - 1) == 1 || arr.get(arr.size() - 2) == 1) {
                    sum += (arr.get(arr.size() - 1) + arr.get(arr.size() - 2));
                } else {
                    sum += (arr.get(arr.size() - 1) * arr.get(arr.size() - 2));
                }

                arr.remove(arr.size() - 1);
                arr.remove(arr.size() - 1);
            }

            if(brr.size() > 1) {
                sum += (brr.get(0) * brr.get(1));
                brr.remove(0);
                brr.remove(0);
            }
        }

        if(arr.size() == 1) {
            sum += arr.get(0);
        }

        if(brr.size() == 1) {
            sum += brr.get(0);
        }

        System.out.print(sum);
    }
}
