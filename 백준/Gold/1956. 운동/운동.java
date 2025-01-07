import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int v, e;
	static long[][] dist;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		v = sc.nextInt();
		e = sc.nextInt();
		dist = new long[v+1][v+1];
		for(int i = 1; i <= v; i++) {
			Arrays.fill(dist[i], 2_000_000_000);
		}
		
		for(int i = 0; i < e; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int c = sc.nextInt();
			dist[u][v] = c;
		}
		
		for(int k = 1; k <= v; k++) {
			for(int i = 1; i <= v; i++) {

				for(int j = 1; j <= v; j++) {

					if(dist[i][j] > dist[i][k] + dist[k][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}
		
		long res = 2_000_000_000;
		for(int i = 1; i <= v; i++) {
			res = Math.min(res, dist[i][i]);
		}
		
		System.out.println(res == 2_000_000_000 ? -1 : res);
	}
}
