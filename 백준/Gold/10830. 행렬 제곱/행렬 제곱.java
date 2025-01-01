import java.util.Scanner;

public class Main {
	static int[][] arr, res = new int[5][5];
	static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		long b = sc.nextLong();
		arr = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
				arr[i][j] %= 1000;
			}
		}
		
		res = go(b);
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				sb.append(res[i][j]).append(' ');
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	static int[][] go(long b){
		if(b == 1) return arr;
		
		int[][] matrix = go(b/2);
		if(b % 2 == 1) {
			
			return multiplication(multiplication(matrix, matrix), arr);
		} 
		
		return multiplication(matrix, matrix);

	}
	
	static int[][] multiplication(int[][] a, int[][] b) {
		int[][] r = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					r[i][j] += (a[i][k] * b[k][j]);
					r[i][j] %= 1000;
				}
			}
		}
		
		return r;
	}
}
