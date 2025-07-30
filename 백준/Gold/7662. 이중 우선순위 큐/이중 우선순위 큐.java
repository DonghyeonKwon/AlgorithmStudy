import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                char a = st.nextToken().charAt(0);

                if(a == 'I') {
                    int num = Integer.parseInt(st.nextToken());
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {
                    if(map.size() == 0) continue;

                    int type = Integer.parseInt(st.nextToken());
                    int num;
                    if(type == 1) {
                        num = map.lastKey();
                    } else {
                        num = map.firstKey();
                    }

                    int p = map.get(num);
                    if(p == 1) map.remove(num);
                    else map.put(num, p-1);
                }
            }

            if(map.isEmpty()) {
                bw.write("EMPTY\n");
            } else {
                bw.write(map.lastKey() + " " + map.firstKey() + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
