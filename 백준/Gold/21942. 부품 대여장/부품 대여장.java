import java.io.*;
import java.util.*;

public class Main {
    static int n, f;
    static int ld, lh, lm, range;
    static Map<String, Long> map = new HashMap<>();
    static Map<String, Long> sumMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        String[] arr = st.nextToken().split("/");
        String[] brr = arr[1].split(":");
        ld = Integer.parseInt(arr[0]);
        lh = Integer.parseInt(brr[0]);
        lm = Integer.parseInt(brr[1]);
        range = ld * 24 * 60 + lh * 60 + lm;
        f = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String d = st.nextToken();
            String t = st.nextToken();
            long time = calc(d, t);
            String thing = st.nextToken();
            String name = st.nextToken();
            String id = thing + "_" + name;

            if(map.containsKey(id)) {
                long diff =  time - map.get(id);
                if(diff > 0) {
                    if(sumMap.containsKey(name)) {
                        sumMap.put(name, sumMap.get(name) + diff * f);
                    } else {
                        sumMap.put(name, diff * f);
                    }
                }

                map.remove(id);
            } else {
                map.put(id, time + range);
            }
        }

        List<String> list = new ArrayList<>(sumMap.keySet());
        list.sort((a, b) -> a.compareTo(b));
        if(list.isEmpty()) {
            System.out.print(-1);
        } else {
            StringBuilder sb = new StringBuilder();

            for(String a : list) {
                sb.append(a).append(' ').append(sumMap.get(a)).append('\n');
            }

            System.out.print(sb);
        }
    }

    static long calc(String date, String time) {
        String[] arr = date.split("-");
        long month = Integer.parseInt(arr[1]);
        long day = Integer.parseInt(arr[2]);

        arr = time.split(":");
        long hour = Integer.parseInt(arr[0]);
        long min = Integer.parseInt(arr[1]);

        for(int i = 1; i < month; i++) {
            day += getDay(i);
        }

        return day * 24 * 60 + hour * 60 + min;
    }

    static long getDay(int i) {
        if(i == 2) return 28;
        if(i == 4 || i == 6 || i == 9 || i == 11) return 30;
        return 31;
    }
}
