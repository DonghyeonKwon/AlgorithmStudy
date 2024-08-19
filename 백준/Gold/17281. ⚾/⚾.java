import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int n, max = 0;
	static int[] order = {0, 1, 2, 3, 4, 5, 6, 7, 8};
	static int[] select;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n][9];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		select = new int[9];
		
		dfs(0, 0);
		
		bw.write(max + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(int ecnt, int idx) {
		if(ecnt == ((1 << 9) - 1)) {
			if(select[3] != 0) return;
			
			int i = 0, score = 0;
			for(int j = 0; j < n; j++) {
				int out = 0;
				boolean[] base = {false, false, false};
				while(true) {
					if(map[j][select[i]] == 0) {
						out++;
					} else if(map[j][select[i]] == 1) {
						if(base[2] == true) {
							score++;
							base[2] = false;
						}
						base[2] = base[1];
						base[1] = base[0];
						base[0] = true;
					} else if(map[j][select[i]] == 2) {
						if(base[2]) {
							score++;
							base[2] = false;
						}
						if(base[1]) {
							score++;
							base[1] = false;
						}
						base[2] = base[0];
						base[0] = false;
						base[1] = true;
					} else if(map[j][select[i]] == 3) {
						if(base[2]) {
							score++;
							base[2] = false;
						}
						if(base[1]) {
							score++;
							base[1] = false;
						}
						if(base[0]) {
							score++;
							base[0] = false;
						}
						
						base[2] = true;
					} else if(map[j][select[i]] == 4) {
						int cnt = 0;
						for(int k = 0; k < 3; k++) {
							if(base[k]) cnt++;
							base[k] = false;
						}
						score += cnt + 1;
		
					}
					
					
					if(i + 1 == 9) i = 0;
					else i += 1;
					
					if(out == 3) {
						break;
					}
				}
			}
			max = Math.max(max, score);
			return;
		}
		
		for(int i = 0; i < 9; i++) {
			if((ecnt & (1 << i)) == 0) {
				select[idx] = order[i];
				dfs(ecnt | (1 << i), idx + 1);
			}
		}
	}
}
