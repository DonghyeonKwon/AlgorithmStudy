import java.util.Scanner;

public class Main {
	static int[][] arr = new int[5][5];
	static boolean[][] visited = new boolean[5][5];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int cnt = 0;
		
		loop : for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j ++) {
				int input = sc.nextInt();
				cnt++;
				boolean flag = check(input);
				
				if(flag) {
					System.out.println(cnt);
					break loop;
				}
			}
		}
	}
	
	static boolean check(int input) {
		loop : for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(input == arr[i][j]) {
					visited[i][j] = true;
					break loop;
				}
			}
		}
	
		int bingo = 0;
		for(int i = 0; i < 5; i++) {
			if(visited[i][0] && visited[i][1] && visited[i][2] && visited[i][3] && visited[i][4]) bingo++;
			if(visited[0][i] && visited[1][i] && visited[2][i] && visited[3][i] && visited[4][i]) bingo++;
		}
		if(visited[0][0] && visited[1][1] && visited[2][2] && visited[3][3] && visited[4][4]) bingo++;
		if(visited[0][4] && visited[1][3] && visited[2][2] && visited[3][1] && visited[4][0]) bingo++;
		
		if(bingo >= 3) return true;
		return false;
	}
}
