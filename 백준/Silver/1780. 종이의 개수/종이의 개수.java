import java.io.*;
import java.util.*;

public class Main {
	static int res[] = new int[3];
	static int map[][];
	
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
		
		int k = divide(0, 0, n);
		if(k != -2) {
			res[k+1]++;
		}
		
		for(int i = 0; i < 3; i++) {
			System.out.println(res[i]);
		}
	}
	
	static int divide(int y, int x, int size) {
		if(size == 1) {
			return map[y][x];
		}
		
		int ret[][] = new int[3][3];
		boolean flag = true;
		int num = -2;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				ret[i][j] = divide(y + size/3 * i, x + size/3 * j, size/3);
				if(num == -2) {
					num = ret[i][j];
				} else {
					flag &= (num == ret[i][j]);
				}
			}
		}
		
		if(flag) {
			return num;
		}
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(ret[i][j] == -2) continue;
				res[ret[i][j]+1]++;
			}
		}
		return -2;
		
	}
}