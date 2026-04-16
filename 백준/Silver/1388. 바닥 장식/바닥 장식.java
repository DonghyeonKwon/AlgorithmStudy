import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static char[][] map;
	static boolean[][] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][];
		v = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(v[i][j]) continue;
				if(map[i][j] == '-') {
					dfs(i, j, '-', 0, 1);
				} else if(map[i][j] == '|') {
					dfs(i, j, '|', 1, 0);
				}
				cnt++;
			}
		}
		
		bw.write(Integer.toString(cnt));
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(int y, int x, char c, int dy, int dx) {
		if(y >= n || x >= m) return;
		if(map[y][x] != c) return;
		if(v[y][x]) return;
		
		v[y][x] = true;
		dfs(y+dy, x+dx, c, dy, dx);
	}
}