import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
	static char[][] map = new char[12][6];
	static boolean[][] visited;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 12; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int res = 0;
		while(true) {
			visited = new boolean[12][6];
			
			boolean flag = false;
			for(int i = 11; i >= 0; i--) {
				for(int j = 0; j < 6; j++) {
					if(!visited[i][j] && map[i][j] != '.') {
						flag |= bfs(i, j, map[i][j]);
					}
				}
			}
			
			if(!flag) break;
			res++;
			
			Queue<Character> q = new ArrayDeque<>();
			for(int j = 0; j <6; j++) {
				for(int i = 11; i >= 0; i--) {
					if(map[i][j] != '.') {
						q.offer(map[i][j]);
					}
				}
				
				if(q.isEmpty()) continue;
				for(int i = 11; i >= 0; i--) {
					if(q.isEmpty()) {
						map[i][j] = '.';
						continue;
					}
					map[i][j] = q.poll().charValue();
				}
			}
				
		}
		
		System.out.println(res);
	}
	
	static boolean bfs(int y, int x, char c) {
		Queue<int[]> q = new ArrayDeque<>();
		List<int[]> list = new ArrayList<>();
		
		q.offer(new int[] {y, x});
		visited[y][x] = true;
		list.add(new int[] {y, x});
		
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			y = pos[0];
			x = pos[1];
			
			for(int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				
				if(ny < 0 || ny >= 12 || nx < 0 || nx >= 6) continue;
				if(map[ny][nx] != c) continue;
				if(visited[ny][nx]) continue;
				
				visited[ny][nx] = true;
				q.offer(new int[] {ny, nx});
				list.add(new int[] {ny, nx});
			}
		}
		
		if(list.size() >= 4) {
			for(int[] pos : list) {
				map[pos[0]][pos[1]] = '.';
			}
			
			return true;
		}
		
		return false;
	}
}