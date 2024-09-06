import java.io.*;
import java.util.*;

public class Main {
	static int[][] pan = new int[21][21];
	static int[][][] check = new int[4][21][21];
	
	static int[] dy = {1, 0, 1, 1};
	static int[] dx = {0, 1, 1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 1; i < 20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j < 20; j++) {
				pan[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i < 20; i++) {
			for(int j = 1; j < 20; j++) {
				if(pan[i][j] == 0) continue;
				for(int d = 0; d < 4; d++) {
					if(dfs(i, j, pan[i][j], 0, d) == 5) {
						System.out.println(pan[i][j]);
						if(d == 3) {
							System.out.println((i + 4) + " " + (j - 4));
						} else {
							System.out.println(i + " " + j);
						}
						return;
					}
				}
			}
		}
		System.out.println(0);
	}
	
	static int dfs(int y, int x, int idx, int cnt, int d) {
		if(check[d][y][x] > 0) return -1;
		
		if(pan[y][x] != idx) {
			return cnt;
		}
		
		return check[d][y][x] = dfs(y + dy[d], x + dx[d], idx, cnt+1, d);
	}
	
	static boolean check(int y, int x) {
		return (1 <= y && y <= 19 && 1 <= x && x <= 19);
	}
}
