import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[][] map, v;
	
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, -1, 0, 1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//입력
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		v = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				v[i][j] = -1;
			}
		}
		
		System.out.println(dfs(0, 0));
	}
	
	static int dfs(int y, int x) {
		if(y == n-1 && x == m-1) return 1;
		if(v[y][x] != -1) return v[y][x];
		
		v[y][x] = 0;
		
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
			if(map[ny][nx] >= map[y][x]) continue;
			v[y][x] += dfs(ny, nx);
		}
		
		return v[y][x];
	}
}