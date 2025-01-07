import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n, m;
	static Edge[] edge;
	static long[] cost;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		cost = new long[n+1];
		edge = new Edge[m];
		Arrays.fill(cost, Integer.MAX_VALUE);
		
		for(int i = 0; i < m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int c = sc.nextInt();
			
			edge[i] = new Edge(u, v, c);
		}
		
		boolean flag = bellman_ford(1);
		
		if(flag) {
			System.out.print(-1);
		} else {
			StringBuilder sb = new StringBuilder();
			for(int i = 2; i <= n; i++) {
				sb.append(cost[i] == Integer.MAX_VALUE ? -1 : cost[i]).append('\n');
			}
			System.out.print(sb);
		}
	}
	
	static boolean bellman_ford(int start) {
		cost[start] = 0;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				int u = edge[j].u;
				int v = edge[j].v;
				int c = edge[j].c;
				
				if(cost[u] != Integer.MAX_VALUE && cost[v] > cost[u] + c) {
					cost[v] = cost[u] + c;
					if(i == n - 1) return true;
				}
			}
		}
		
		return false;
	}
	
	static class Edge{
		int u, v, c;
		Edge(int u, int v, int c){
			this.u = u;
			this.v = v;
			this.c = c;
		}
	}
}
