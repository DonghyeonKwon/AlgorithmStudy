import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	static int n, m;
	static int[][] map;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			String[] input = br.readLine().split("");
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		go(y, x, k);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				bw.write("" + map[i][j]);
			}
			bw.write("\n");
		}
		bw.flush();
		
		bw.close();
		br.close();
	}
	
	static void go(int y, int x, int k) {
		boolean[][] visited = new boolean[n][m];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {y, x});
		visited[y][x] = true;
		int a = map[y][x];
		map[y][x] = k;
		
		while(!q.isEmpty()) {
			y = q.peek()[0];
			x = q.peek()[1];
			q.poll();
			
			for(int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(0 <= ny && ny < n && 0 <= nx && nx < m && !visited[ny][nx] && map[ny][nx] == a) {
					map[ny][nx] = k;
					visited[ny][nx] = true;
					q.add(new int[] {ny, nx});
				}
			}
		}
	}
}