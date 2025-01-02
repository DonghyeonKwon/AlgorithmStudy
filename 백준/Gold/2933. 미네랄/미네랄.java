import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int r, c;
	static char[][] map = new char[100][100];
	static int[][] visited;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		r = sc.nextInt();
		c = sc.nextInt();
		
		for(int i = 0; i < r; i++) {
			map[i] = sc.next().toCharArray();
		}
		
		int m = sc.nextInt();
		for(int order = 0; order < m; order++) {
			int a = sc.nextInt();
			if(order % 2 == 1) {
				for(int i = c - 1; i >= 0; i--) {
					if(map[r - a][i] == 'x') {
						map[r - a][i] = '.';
						break;
					}
				}
			} else {
				for(int i = 0; i < c; i++) {
					if(map[r - a][i] == 'x') {
						map[r - a][i] = '.';
						break;
					}
				}
			}
			
			int cnt = 0;
			visited = new int[r][c];
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					if(visited[i][j] == 0 && map[i][j] == 'x') {
						cnt++;
						bfs(i, j, cnt);
					}
				}
			}
			
			int g_cnt = 0;
			boolean[] ground = new boolean[cnt+1]; 
			if(cnt >= 2) {
				for(int i = 0; i < c; i++) {
					if(visited[r-1][i] == 0) continue;
					if(!ground[visited[r-1][i]]) {
						ground[visited[r-1][i]] = true;
						g_cnt++;
					}
				}
			}
			
//			System.out.println(cnt + " " + g_cnt);
//			System.out.println(Arrays.toString(ground));
			if(cnt == g_cnt) continue;
			
			for(int i = 1; i <= cnt; i++) {
				if(ground[i]) continue;
				
				int min = 1000;
				for(int j = 0; j < c; j++) {
					int start = -1;
					int down = 0;
					for(int k = 0; k < r; k++) {
						down++;
//						System.out.println(down);
						if(visited[k][j] == 0) continue;
						if(visited[k][j] == i) {
							start = k;
							down = 0;
						} else {
							if(start != -1) min = Math.min(min, down-1);
						}
					}
					if(start != -1) {
						min = Math.min(min, down);
					}
				}
				
//				System.out.println(min);
				for(int j = 0; j < c; j++) {
					for(int k = r-1; k >= 0; k--) {
						if(visited[k][j] == i) {
							map[k][j] = '.';
							map[k+min][j] = 'x';
						}
					}
				}
			}
				
			
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				sb.append(map[i][j]);
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	static void bfs(int y, int x, int ccc) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] {y, x});
		visited[y][x] = ccc;
		
		while(!queue.isEmpty()) {
			int[] pos = queue.poll();
			y = pos[0];
			x = pos[1];
			
			for(int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(ny < 0 || ny >= r || nx < 0 || nx >= c) continue;
				if(visited[ny][nx] > 0) continue;
				if(map[ny][nx] == '.') continue;
				visited[ny][nx] = ccc;
				queue.offer(new int[] {ny, nx});
			}
		}
	}
}
