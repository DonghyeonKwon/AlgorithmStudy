import java.io.*;
import java.util.*;

public class Main {
	static int garo[] = new int[9];
	static int sero[] = new int[9];
	static int can[][] = new int[3][3];
	static int map[][] = new int[9][9];
	static List<int[]> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int i = 0; i < 9; i++) {
			char[] input = br.readLine().toCharArray();
			for(int j = 0; j < 9; j++) {
				map[i][j] = input[j] - '0';
				if(map[i][j] == 0) {
					list.add(new int[] {i, j});
				} else {
					garo[i] |= (1 << map[i][j]);
					sero[j] |= (1 << map[i][j]);
					can[i/3][j/3] |= (1 << map[i][j]);
				}
			}
		}
		
		go(0);
	}
	
	static boolean go(int idx) {
		if(idx == list.size()) {
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			
			System.out.println(sb.toString());
			
			return true;
		}
		
		boolean flag = false;
		int[] pos = list.get(idx);
		int y = pos[0];
		int x = pos[1];
		
		for(int i = 1; i <= 9 && !flag; i++) {
			if((garo[y] & (1 << i)) != 0) continue; 
			if((sero[x] & (1 << i)) != 0) continue; 
			if((can[y/3][x/3] & (1 << i)) != 0) continue;
			garo[y] |= (1 << i);
			sero[x] |= (1 << i);
			can[y/3][x/3] |= (1 << i);
			
			map[y][x] = i;
			flag |= go(idx+1);
			
			if(flag) return flag;
			
			garo[y] ^= (1 << i);
			sero[x] ^= (1 << i);
			can[y/3][x/3] ^= (1 << i);
		}	
		
		return flag;
	}
}