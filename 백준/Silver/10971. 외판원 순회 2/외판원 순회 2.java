import java.io.*;
import java.util.*;

public class Main {
	static int n, res = Integer.MAX_VALUE;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        
		for(int i = 0; i < n; i++) {
			go((1 << i), i, i, 1, 0);
		}
		
		System.out.println(res);
	}
	
	static void go(int ecnt, int s, int prev, int cnt, int sum) {
		if(cnt == n) {
			if(ecnt != (1 << n) - 1) return;
            if(map[prev][s] == 0)return;
			if(res > sum + map[prev][s]) res = sum + map[prev][s];
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if((ecnt & (1 << i)) > 0) continue;
			if(map[prev][i] == 0) continue;
			go(ecnt | (1 << i), s, i, cnt+1, sum + map[prev][i]);
		}
	}
}