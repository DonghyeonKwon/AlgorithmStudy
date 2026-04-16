import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int res[] = new int[4];
		res[0] = divide(0, 0, n/2);
		res[1] = divide(0, n/2, n/2);
		res[2] = divide(n/2, 0, n/2);
		res[3] = divide(n/2, n/2, n/2);
		
		Arrays.sort(res);
		
		System.out.println(res[2]);
	}
	
	static int divide(int y, int x, int size) {
		if(size == 1) {
			return map[y][x];
		}
		
		int ret[] = new int[4];
		
		ret[0] = divide(y, x, size/2);
		ret[1] = divide(y, x + size/2, size/2);
		ret[2] = divide(y + size/2, x, size/2);
		ret[3] = divide(y + size/2, x + size/2, size/2);
		
		Arrays.sort(ret);
		
		return ret[2];
	}
}