import java.util.Scanner;

public class Main {
	static int[][] map;
	static int n, turn;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int t = sc.nextInt();
		for(int tc = 0; tc < t; tc++) {
			n = sc.nextInt();
			turn = sc.nextInt();
			turn = (360 + turn) % 360;
			int k = turn / 45;
			map = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 0; i < k; i++) {
				turnMap();
			}
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
	
	static void turnMap() {
		int y = 0, x = 0;
		for(int i = n / 2; i > 0; i--) {
			int starty = y;
			int startx = x;
			
			for(int j = 0; j < 2; j++) {
				map[starty][startx] = swap(map[starty + i][startx], map[starty + i][startx] = map[starty][startx]);
				starty += i;
			}
			for(int j = 0; j < 2; j++) {
				map[starty][startx] = swap(map[starty][startx+i], map[starty][startx+i] = map[starty][startx]);
				startx += i;
			}
			for(int j = 0; j < 2; j++) {
				map[starty][startx] = swap(map[starty-i][startx], map[starty-i][startx] = map[starty][startx]);
				starty -= i;
			}
			for(int j = 0; j < 1; j++) {
				map[starty][startx] = swap(map[starty][startx - i], map[starty][startx-i] = map[starty][startx]);
				startx -= i;
			}
			
			y++;
			x++;
		}
	}
	
	static int swap(int a, int b) {
		return a;
	}
}
