import java.io.*;

public class Main {
	static int n;
	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new char[n][n];
		boolean[][] visited = new boolean[n][n];
		for(int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		long res = 0;
		for(int i = 0; i < n; i++) {
			long cnt = 0;
			for(int j = 0; j < n; j++) {
				if(i == j) continue;
				
				if(map[i][j] == 'Y') {
					cnt++;
					visited[i][j] = true;
					continue;
				}
				
				for(int k = 0; k < n; k++) {
					if(i == k || j == k || visited[i][j]) continue;
					if(map[k][i] == 'Y' && map[k][j] == 'Y') {
						cnt++;
						visited[i][j] = true;
					}
				}
			}
			res = res < cnt ? cnt : res;
		}
		
		System.out.println(res);
	}
}