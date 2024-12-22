import java.util.Scanner;

public class Main {
	static int n, res = 0;
	static int[][] input;
	static int[] order = new int[10];
	static boolean[] visited = new boolean[10];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		input = new int[n][10];
		for(int i = 0; i < n; i++) {
			for(int j = 1; j <= 9; j++) {
				input[i][j] = sc.nextInt();
			}
		}
		
		order[4] = 1;
		visited[1] = true;
		combi(1);
		
		System.out.println(res);
	}
	
	static void combi(int cnt) {
		if(cnt == 10) {
			game();
			return;
		}
		
		if(cnt == 4) {
			combi(cnt+1);
			return;
		}
		
		for(int i = 1; i <= 9; i++) {
			if(visited[i]) continue;
			order[cnt] = i;
			visited[i] = true;
			combi(cnt+1);
			visited[i] = false;
		}
	}
	
	static void game() {
		int score = 0;
		int idx = 1;
		for(int i = 0; i < n; i++) {
			boolean[] base = new boolean[4];
			int out = 0;
			
			while(out < 3) {
				int k = order[idx];
				if(input[i][k] == 0) {
					out++;
				} else if(input[i][k] == 1) {
					for(int j = 3; j > 0; j--) {
						if(base[j]) {
							if(j+1 >= 4) {
								score++;
								base[j] = false;
							} else {
								base[j+1] = true;
								base[j] = false;
							}
						}
					}
					base[1] = true;
				} else if(input[i][k] == 2) {
					for(int j = 3; j > 0; j--) {
						if(base[j]) {
							if(j+2 >= 4) {
								score++;
								base[j] = false;
							} else {
								base[j+2] = true;
								base[j] = false;
							}
						}
					}
					base[2] = true;
				} else if(input[i][k] == 3) {
					for(int j = 1; j <= 3; j++) {
						if(base[j]) {
							score++;
							base[j] = false;
						}
					}
					base[3] = true;
				} else if(input[i][k] == 4) {
					for(int j = 1; j <= 3; j++) {
						if(base[j]) {
							score++;
							base[j] = false;
						}
					}
					score++;
				}
				
				idx++;
				if(idx == 10) idx = 1;
			}
		}
		
		res = Math.max(res, score);
	}
}
