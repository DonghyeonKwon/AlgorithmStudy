import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
	static int N;
	static int[][] map;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			String[] input = br.readLine().split("");
			for(int j = 0; j < N; j++) {
				if(Integer.parseInt(input[j]) == 1) map[i][j] = -1;
			}
		}
		
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 0) continue;
				if(map[i][j] == -1) {
					cnt++;
					bfs(i, j, cnt);
				}
			}
		}
		
		int[] res = new int[cnt];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 0) continue;
				res[map[i][j] - 1]++;
			}
		}
		
		Arrays.sort(res);
		
		StringBuilder sb = new StringBuilder();
		sb.append(cnt).append("\n");
		for(int i = 0; i < cnt; i++) {
			sb.append(res[i]).append("\n");
		}
		
		bw.write(sb.toString().toCharArray());
		bw.close();
	}
	
	static void bfs(int y, int x, int v) {
		Queue<Pos> q = new ArrayDeque<>();
		q.offer(new Pos(y, x));
		
		map[y][x] = v;
		
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			for(int i = 0; i < 4; i++) {
				int ny = p.y + dy[i];
				int nx = p.x + dx[i];
				
				if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
				if(map[ny][nx] == v || map[ny][nx] == 0) continue;
				map[ny][nx] = v;
				q.offer(new Pos(ny, nx));
			}
		}
	}
	
	static class Pos{
		int y, x;
		Pos(int y, int x) { this.y = y; this.x = x; }
	}
}
