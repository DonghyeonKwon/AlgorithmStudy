import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int r, c, Dy, Dx, Sy, Sx, min = Integer.MAX_VALUE;
	static char[][] map;
	static int[][] water;
	static boolean[][] visited;
	
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		water = new int[r][c];
		visited = new boolean[r][c];
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				water[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for(int i = 0; i < r; i++) {
			char[] line = br.readLine().toCharArray();
			for(int j = 0; j < c; j++) {
				map[i][j] = line[j];
				if(map[i][j] == 'D') {
					Dy = i;
					Dx = j;
					continue;
				}
				if(map[i][j] == 'S') {
					Sy = i;
					Sx = j;
					continue;
				}
			}
		}
		
		//물에 시간에 따라 차오르는 맵을 만들고(bfs) 해당 맵에서 dfs 하기		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(map[i][j] == '*') {
					fillWater(i, j);
				}
			}
		}

		bfs(Sy, Sx, 0);
		
		if(min == Integer.MAX_VALUE) sb.append("KAKTUS\n");
		else sb.append(min).append("\n");
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void bfs(int y, int x, int t) {
		Queue<Data> q = new ArrayDeque<>();
		q.offer(new Data(y, x, t));
		visited[y][x] = true;
		
		while(!q.isEmpty()) {
			Data data = q.poll();
			y = data.y;
			x = data.x;
			t = data.t;
			
			if(y == Dy && x == Dx) {
				if(min > t) min = t;
				continue;
			}
			
			for(int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				int nt = t + 1;
				
				if(nx < 0 || nx >= c || ny < 0 || ny >= r) continue;
				if(map[ny][nx] == 'X' || map[ny][nx] == '*') continue;
				if(water[ny][nx] <= nt) continue;
				if(visited[ny][nx]) continue;
				visited[ny][nx] = true;
				q.offer(new Data(ny, nx, nt));
			}
		}
    }
	
	static void fillWater(int y, int x) {
		Queue<Pos> queue = new ArrayDeque<>();
		water[y][x] = 0;
		queue.offer(new Pos(y, x));
		
		while(!queue.isEmpty()) {
			Pos p = queue.poll();
			y = p.y;
			x = p.x;
			
			for(int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
				if(map[ny][nx] == 'X' || map[ny][nx] == 'D') continue;
				if(water[ny][nx] <= water[y][x] + 1) continue;
				
				water[ny][nx] = water[y][x] + 1;
				queue.offer(new Pos(ny, nx));
			}
		}
	}
	
	static class Pos{
		int y, x;
		Pos(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	
	static class Data extends Pos {
		int t;
		Data(int y, int x, int t){
			super(y, x);
			this.t = t;
		}
	}
}
