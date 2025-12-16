import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        TreeMap<String, Integer> map = new TreeMap<>();
        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            map.put(input, map.getOrDefault(input, 0) + 1);
        }

        Book[] arr = new Book[map.size()];

        int idx = 0;
        for(String key : map.keySet()) {
            arr[idx++] = new Book(key, map.get(key));
        }

        Arrays.sort(arr);

        System.out.print(arr[0].title);
    }

    static class Book implements Comparable<Book> {
        String title;
        int cnt;

        Book(String title, int cnt) {
            this.title = title;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Book o) {
            if(o.cnt == this.cnt) {
                return this.title.compareTo(o.title);
            }
            return o.cnt - this.cnt;
        }
    }
}
