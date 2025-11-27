import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";
        Map<Arr, List<String>> map = new HashMap<>();
        while((str = br.readLine()) != null && !str.isEmpty()) {
            int[] arr = new int[26];
            for(int i = 0; i < str.length(); i++) {
                arr[str.charAt(i) - 'a']++;
            }
            Arr a = new Arr(str.length(), arr);

            if(!map.containsKey(a)) {
                map.put(a, new ArrayList<>());
            }


            map.get(a).add(str);
        }

        List<List<String>> list = new ArrayList<>(map.values());
        Collections.sort(list, (o1, o2) -> {
            if(o1.size() == o2.size()) {
                return o1.get(0).compareTo(o2.get(0));
            }
            return o2.size() - o1.size();
        });

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(List<String> set : list) {
            if(cnt == 5) break;
            sb.append("Group of size ").append(set.size()).append(":");
            Set<String> sSet = new TreeSet<>(set);
            for(String ss : sSet) {
                sb.append(" ").append(ss);
            }
            sb.append(" .\n");

            cnt++;
        }

        System.out.print(sb);
    }

    static class Arr {
        int len;
        int[] arr;
        int cnt = 0;

        Arr(int len, int[] arr) {
            this.len = len;
            this.arr = arr;
        }

        @Override
        public int hashCode() {
            int result = len;
            for(int i = 0; i < 26; i++) {
                result = 31 * result + arr[i];
            }
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(o == null || this.getClass() != o.getClass()) return false;
            Arr other = (Arr) o;
            if(this.len != other.len) return false;
            return Arrays.equals(this.arr, other.arr);
        }
    }
}
