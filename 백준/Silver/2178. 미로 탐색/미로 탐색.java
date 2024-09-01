import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static char[][] map;
	static int[][] v;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][];
		v = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		bfs(0, 0);
		
		bw.write(Integer.toString(v[n-1][m-1]));
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void bfs(int y, int x) {
		Queue<Data> q = new ArrayDeque<>();
		v[y][x] = 1;
		q.offer(new Data(y,x));
		
		while(!q.isEmpty()) {
			Data d = q.poll();
			y = d.y;
			x = d.x;
			
			for(int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
				if(v[ny][nx] > 0) continue;
				if(map[ny][nx] == '0') continue;
				v[ny][nx] = v[y][x] + 1;
				q.offer(new Data(ny, nx));
			}
		}
	}
	
	static class Data{
		int y, x;
		Data(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
}