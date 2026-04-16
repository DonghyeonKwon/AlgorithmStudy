import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int n, m, k, ret = 0;
	//다이스 이렇게 본다. 윗면은 (1,1), 아랫면은 (1, 3)
	static int[][] dice = {
				/*동*/
			{0, 3, 0, 0},
	/*북*/	{2, 1, 5, 6},	/*서*/
			{0, 4, 0, 0}
				/*서*/
	};
	static int[][] map;
	
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	
	static int d = 3; //방향 0:북, 1:서, 2:남, 3:동
		
	public static void main(String[] args) throws IOException {
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		map = new int[n+1][m+1];
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력
		
		//이 문제는 방향대로 한칸씩 이동 -> bfs -> 방향 조절 을 k번 반복한 문제
		int[] pos = {1, 1};
		for(int i = 0; i < k; i++) {
			move(pos);
			bfs(pos, map[pos[0]][pos[1]]);
			modulateDestination(dice[1][3], map[pos[0]][pos[1]]);
		}
		
		System.out.println(ret);
	}
	
	static void move(int[] pos) {
		pos[0] += dy[d];
		pos[1] += dx[d];
		
		//한 칸 갔는데 경계에 벗어낫다면
		if(0 >= pos[0] || 0 >= pos[1] || n < pos[0] || m < pos[1]) {
			d = (d+2) % 4;
			pos[0] += dy[d]*2;
			pos[1] += dx[d]*2;
		}
		//방향별 주사위 굴리기
		switch(d) {
			case 0:
				for(int i = 0; i < 3; i++) {
					dice[1][i+1] = swap(dice[1][i], dice[1][i] = dice[1][i+1]);
				}
				break;
			case 1:
				for(int i = 2; i > 0; i--) {
					dice[i-1][1] = swap(dice[i][1], dice[i][1] = dice[i-1][1]);
				}
				dice[1][3] = swap(dice[0][1], dice[0][1] = dice[1][3]);
				break;
			case 2:
				for(int i = 3; i > 0; i--) {
					dice[1][i-1] = swap(dice[1][i], dice[1][i] = dice[1][i-1]);
				}
				break;
			case 3:
				for(int i = 0; i < 2; i++) {
					dice[i+1][1] = swap(dice[i][1], dice[i][1] = dice[i+1][1]);
				}
				dice[1][3] = swap(dice[2][1], dice[2][1] = dice[1][3]);
				break;
		}
	}
	
	static int swap(int a, int b) {
		return a;
	}
	
	static void bfs(int[] yx, int B) {
		int C = 1;
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[n+1][m+1];
		
		q.add(yx);
		visited[yx[0]][yx[1]] = true;
		
		while(!q.isEmpty()) {
			int y = q.peek()[0];
			int x = q.peek()[1];
			q.poll();
			for(int i = 0; i < 4; i++) {
				int ny = y + dy[i];
				int nx = x + dx[i];
				if(ny <= 0 || nx <= 0 || ny > n || nx > m) continue;
				if(map[ny][nx] != B) continue;
				if(visited[ny][nx]) continue;
				visited[ny][nx] = true;
				C++;
				q.add(new int[] {ny, nx});
			}
		}
		ret += (B * C);
	}
	
	static void modulateDestination(int A, int B) {
		if(A < B) { //반시계 방향
			d = (d+1)%4;
		} else if(A > B) { //시계 반향
			if(d == 0) d = 3;
			else d -= 1;
		} //else 이건 A==B. 없어도 된다.
	}
}
