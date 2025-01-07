import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int n, m;
	static int[][] cost;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		cost = new int[n+1][n+1];
		
		for(int i = 1; i <= n; i++) {
			Arrays.fill(cost[i], 999999999);
			cost[i][i] = 0;
		}
		
		for(int i = 0; i < m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int c = sc.nextInt();
			if(c < cost[u][v]) {
				cost[u][v] = c;
			}
		}
		
		for(int k = 1; k <= n; k++) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					if(cost[i][j] > cost[i][k] + cost[k][j]) {
						cost[i][j] = cost[i][k] + cost[k][j];
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				sb.append(cost[i][j] == 999999999 ? 0 : cost[i][j]).append(' ');
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	static class Edge{
		int v, c;
		Edge(int v, int c){
			this.v = v;
			this.c = c;
		}
	}
}
