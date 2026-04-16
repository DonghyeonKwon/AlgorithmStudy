import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] parent;
    static Square[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        arr = new Square[n+1];

        int idx = -1;
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            arr[i] = new Square(x1, x2, y1, y2);

            if(idx > 0) continue;

            if((y1 <= 0 && y2 >= 0 && (x1 == 0 || x2 == 0)) || (x1 <= 0 && x2 >= 0 && (y1 == 0 || y2 == 0))) idx = i;
        }

        for(int i = 1; i < n; i++) {
            for(int j = i+1; j <= n; j++) {
                if(check(i, j)) {
                    union(i ,j);
                }
            }
        }

        int cnt = 0;
        for(int i = 1; i <= n; i++) {
            int p = find(i);
            if(p == i) cnt++;
        }

        if(idx > 0) cnt--;

        System.out.print(cnt);
    }

    static int find(int a) {
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    static boolean check(int left, int right) {

        Square s1 = arr[left];
        Square s2 = arr[right];

        if(s1.x2 < s2.x1) return false;
        if(s1.x1 > s2.x2) return false;
        if(s1.y2 < s2.y1) return false;
        if(s1.y1 > s2.y2) return false;

        if(s1.x1 < s2.x1 && s2.x2 < s1.x2 && s1.y1 < s2.y1 && s2.y2 < s1.y2) return false;
        if(s2.x1 < s1.x1 && s1.x2 < s2.x2 && s2.y1 < s1.y1 && s1.y2 < s2.y2) return false;

        return true;
    }

    static void union(int i, int j) {

        int leftParent = find(i);
        int rightParent = find(j);

        if(leftParent == rightParent) return;

        parent[rightParent] = leftParent;
    }

    static class Square {
        int x1, x2, y1, y2;

        Square(int x1, int x2, int y1, int y2) {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
        }
    }
}
