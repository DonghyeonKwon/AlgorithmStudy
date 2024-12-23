import java.util.Scanner;

public class Main {
	static int n, y, x, total = 0, res = 999999999;
	static int[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		map = new int[n+1][n+1];
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				map[i][j] = sc.nextInt();
				total += map[i][j];
			}
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				for(int d1 = 1; d1 <= n-2; d1++) {
					for(int d2 = 1; d2 <= n-2; d2++) {
						go(i, j, d1, d2);
					}
				}
			}
		}
		
		System.out.println(res);
	}
	
	static void go(int x, int y, int d1, int d2) {
		if(x + d1 + d2 > n) return;
		if(x >= x + d1 + d2) return;
		if(y - d1 < 1 || y + d2 > n) return;
		
		boolean[][] visited = new boolean[n+1][n+1];
		for(int i = 0; i <= d1; i++) {
			visited[x + i][y - i] = true;
			visited[x + d2 + i][y + d2 - i] = true;
		}
		
		for(int i = 0; i <= d2; i++) {
			visited[x + i][y + i] = true;
			visited[x + d1 + i][y - d1 + i]=  true;
		}
		
		int[] sum = new int[6];
		sum[5] = total;
		for(int i = 1; i < x + d1; i++) {
			for(int j = 1; j <= y; j++) {
				if(visited[i][j]) break;
				sum[1] += map[i][j];
				sum[5] -= map[i][j];
			}
		}
		
		for(int i = 1; i <= x + d2; i++) {
			for(int j = n; j > y; j--) {
				if(visited[i][j]) break;
				sum[2] += map[i][j];
				sum[5] -= map[i][j];
			}
		}
		
		for(int i = x+d1; i <= n; i++) {
			for(int j = 1; j < y - d1 + d2; j++) {
				if(visited[i][j]) break;
				sum[3] += map[i][j];
				sum[5] -= map[i][j];
			}
		}
		
		for(int i = x + d2 + 1; i <= n; i++) {
			for(int j = n; j >= y - d1 + d2; j--) {
				if(visited[i][j]) break;
				sum[4] += map[i][j];
				sum[5] -= map[i][j];
			}
		}

		int max = 0;
		int min = 999999999;
		for(int i = 1; i <= 5; i++) {
			max = Math.max(sum[i], max);
			min = Math.min(sum[i], min);
		}
		
		res = Math.min(max - min, res);
	}
}
