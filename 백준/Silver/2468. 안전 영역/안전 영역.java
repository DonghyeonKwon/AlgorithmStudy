import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n, res = 1;
	static int[][] map;
	static boolean[][] visited;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(max < map[i][j]) max = map[i][j];
				if(min > map[i][j]) min = map[i][j];
			}
		}
		
		while(min < max) {
			visited = new boolean[n][n];
			int cnt = 0;
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(map[i][j] <= min) continue;
					if(visited[i][j]) continue;
					
					dfs(i, j, min);
					cnt++;
				}
			}
			if(res < cnt) res = cnt;
			min++;
		}
		
		sb.append(res).append("\n");
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(int y, int x, int m) {
		visited[y][x] = true;
		
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
			if(map[ny][nx] <= m) continue;
			if(visited[ny][nx]) continue;
			dfs(ny, nx, m);
		}
	}
}