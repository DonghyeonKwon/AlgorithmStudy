import java.io.*;
import java.util.*;

public class Main {
	static int n, m, map[][], path[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		map = new int[n][n];
		path = new int[m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			path[i] = Integer.parseInt(st.nextToken()) - 1;
		}
		
		for(int k = 0; k < n; k++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(i == k || k == j || i == j) continue;
					if(map[i][k] == 1 && map[k][j] == 1) {
						map[i][j] = 1;
						map[j][i] = 1;
					}
				}
			}
		}
		
		for(int i = 0; i < m-1; i++) {
			if(path[i] == path[i+1]) continue;
			if(map[path[i]][path[i+1]] == 0) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
}