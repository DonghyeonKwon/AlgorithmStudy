import java.io.*;
import java.util.*;

public class Main {
	static int n, map[][];
	static long v[][];
	static int[] dy = { 1, 0 };
	static int[] dx = { 0, 1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		v = new long[n][n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				v[i][j] = -1L;
			}
		}
		
		System.out.println(dfs(0, 0));
	}
	
	static long dfs(int y, int x) {
		if(y == n-1 && x == n-1) return 1;
		if(v[y][x] != -1) return v[y][x];
		
		v[y][x] = 0;
		
		for(int i = 0; i < 2; i++) {
			int ny = y + dy[i] * map[y][x];
			int nx = x + dx[i] * map[y][x];
			if(ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
			v[y][x] += dfs(ny, nx);
		}
		
		return v[y][x];
	}
}